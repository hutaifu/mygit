import Vue from "vue/dist/vue";

export function addComponent(vue, compoenent, elString, templateString) {
//原生事件不要加，
    //js表达式相关逻辑处理没有
    //作用域插槽总配置项
    let scopedSlots = {};
    let myComp;
    //得到组件构造函数
    let Compoent = Vue.extend(compoenent);
    let tree = parseHTML(templateString);
    dealTree(tree[0], (obj, parent) => {
        //如果父组件是作用域插槽
        let slotScope = "";
        if (parent?.slotKey){
            slotScope = parent.attributes[parent.slotKey]
        }
        //找到绑定事件
        let on = {};
        let props = {};
        let nativeOn = {};
        let key = "";
        let ref = "";
        let attrs = {};
        if (obj.tagName === "template"){
            //插槽
            //是否有v-slot属性
            let sltoKey =  Object.keys(obj.attributes).filter(item =>/^v-slot:/.test(item))[0];
            let afterSltoKey = sltoKey.replace(/^v-slot:/,"");
            if (afterSltoKey && afterSltoKey !== 'default'){
                //是否有参数
                if (obj.attributes[sltoKey]){
                    //作用域插槽
                    scopedSlots[afterSltoKey] = afterSltoKey;
                    obj.slotKey = sltoKey;
                    obj._vnodeConfig = [obj.tagName,{}]
                }else {
                    //非传参插槽
                    obj._vnodeConfig = [obj.tagName,{slot:obj.attributes[sltoKey]}]
                }
            }else {
                //默认插槽
                obj._vnodeConfig = [obj.tagName,{slot:'default'}]
            }
        }
        if (obj.attributes && obj.tagName !== 'template') {
            let keys = Object.keys(obj.attributes)

            // 匹配事件绑定
            function getEventBindings(regex) {
                let matchedKeys = keys.filter(item => regex.test(item));
                matchedKeys.forEach(item => {
                    // 匹配事件名和修饰符
                    let match = item.match(regex);
                    if (match) {
                        let eventName = match[1]; // 获取事件名
                        let modifiers = match[2]; // 获取修饰符
                        // 检查事件名是否存在于组件定义中，如果存在则说明是组件事件，否则是原生事件
                        let fn = vue[obj.attributes[item]];
                        //是否为插槽
                 /*       if(slotScope && !fn){

                        }*/
                        if (match[2] !== 'native') {
                            on[eventName] = fn?.bind(vue);
                        } else {
                            nativeOn[eventName] = fn?.bind(vue);
                        }
                    }
                });
            }

            // 匹配以 @ 或 v-on: 开头的事件绑定
            getEventBindings(/(?:@|v-on:)([a-zA-Z]+)(?:\.([\w.]+))*(?![\w.-]*\.native(?:$|\B))/);


// 获取属性并处理类型
            function getProp(optionsPropertyObj, rel) {

                let afterKeys = keys.filter(item => rel.test(item) && !/(ref|class|key|style)$/.test(item));
                afterKeys.forEach(item => {
                    let afterItem = item.replace(rel, "");
                    let value = obj.attributes[item];
                    // 处理布尔类型
                    if (value === "false") {
                        optionsPropertyObj[item] = false;
                    } else if (value === "true") {
                        optionsPropertyObj[item] = true;
                    } else if (!isNaN(Number(value))) { // 检查是否为数字
                        optionsPropertyObj[item] = Number(value); // 转换为数字
                    } else { // 其他情况，假设是绑定的属性
                        if (vue[value]) {
                            optionsPropertyObj[afterItem] = vue[value]; // 绑定属性
                            vue.$watch(value, {
                                handler(n, o) {
                                    myComp[afterItem] = vue[value];
                                    myComp.$forceUpdate();
                                }, deep: true,
                            })
                        }
                    }
                });
            }

// 匹配以 : 或 v-bind 开头的属性绑定，但排除掉 ref、class、key、style
            getProp(props, /^(:|v-bind:)/);
            // 单独处理 ref, class, key, style 属性
            let refValue = keys.filter(item => /^(:|v-bind:)*ref$/.test(item))[0];
            if (refValue) {
                if (vue[obj.attributes[refValue]]) {
                    ref = vue[obj.attributes[refValue]];
                } else {
                    ref = obj.attributes[refValue];
                }
            }
            let keyValue = keys.filter(item => /^(:|v-bind:)*key$/.test(item))[0];
            if (keyValue) {
                if (vue[obj.attributes[keyValue]]) {
                    key = vue[obj.attributes[keyValue]];
                } else {
                    key = obj.attributes[keyValue]
                }
            }
            //处理原生属性
            keys.filter(item => !/^(@|:|v-)/.test(item)).forEach(item => {
                attrs[item] = obj.attributes[item]
            })
            let options = {on, props, nativeOn, attrs, ref, key};
            if (Object.keys(on).length === 0) {
                delete options.on;
            }
            if (Object.keys(nativeOn).length === 0) {
                delete options.nativeOn;
            }
            //生成虚拟dom
            obj._vnodeConfig = [obj.tagName, options];
        }else if (obj.content) {
            //如果是文本节点，
            if (slotScope){
               obj.content =  convertToTemplateString(obj.content,slotScope)
            }
                obj._vnodeConfig = [obj.content];
        }
    })
    //拼接vnode
    let vNodesTree = concatVNodes(tree[0]);
    //挂载组件
    myComp = new Compoent({
        _isComponent: true, parent: vue, _parentVnode: vNodesTree
    }).$mount(elString);


    function concatVNodes(node, isOneLevel = true) {
        if (!node || !node._vnodeConfig) {
            return '';
        }
        if (isOneLevel) {
            node._vnodeConfig[0] = compoenent;
        }
        // let result = node._vnode;
        if (node.children && node.children.length > 0) {
            let childrenVnod = [];
            node.children.forEach(child => {
                childrenVnod.push(concatVNodes(child, false));
                if(Object.keys(scopedSlots)?.includes(node.slotKey?.replace(/^v-slot:/,""))){
                    scopedSlots[node.slotKey.replace(/^v-slot:/,"")] =(props)=> {
                        debugger
                        let str = JSON.stringify(childrenVnod[childrenVnod.length - 1]).replace("[[","${").replace("]]","}");
                        return JSON.parse(eval(`\`${str}\``));}
                }
            });
            if (isOneLevel && Object.keys(scopedSlots).length !== 0){
                if (!node._vnodeConfig[1]){
                    node._vnodeConfig[1] = {};
                }
                node._vnodeConfig[1].scopedSlots = scopedSlots;
            }
            return vue.$createElement(...node._vnodeConfig, childrenVnod)
        } else {
            //末级节点
            if (node._vnodeConfig.length !== 1) {
                return vue.$createElement(...node._vnodeConfig)
            } else {
                return node._vnodeConfig;
            }
        }
    }
}

function parseHTML(htmlString) {
    const stack = [];
    const root = {tagName: 'root', attributes: {}, children: []};
    let current = root;
    stack.push(current);

    const regex = /<([a-zA-Z0-9]+)([^>]*)>|<\/([a-zA-Z0-9]+)>|([^<>]+)/g;

    let match;

    while ((match = regex.exec(htmlString)) !== null) {
        const [text, openTag, attributes, closeTag, plainText] = match;
        if (openTag) {
            const node = {tagName: openTag, attributes: parseAttributes(attributes), children: []};
            current.children.push(node);
            stack.push(node);
            current = node;
        } else if (closeTag) {
            stack.pop();
            current = stack[stack.length - 1];
        } else if (plainText && plainText.trim()) {
            current.children.push({content: plainText.trim()});
        }
    }

    return root.children;
}

function parseAttributes(attributeString) {
    const attributes = {};
    const attrRegex = /([^=\s]+)\s*=\s*(['"])(.*?)\2|\b([^=\s]+)\b/g;

    let match;
    while ((match = attrRegex.exec(attributeString)) !== null) {
        const [, name, quote, value] = match;
        if (name && value !== undefined) {
            attributes[name] = value;
        } else if (name) {
            // 处理没有指定值的属性
            attributes[name] = true;
        }
    }

    return attributes;
}

//递归函数
function dealTree(tree, callback,parent) {
    {
        if (typeof tree === "object"){
            callback(tree, parent);
            if (tree?.children?.length > 0) {
                tree.children.forEach(item =>{
                    dealTree(item,callback,tree);
                })
            }
        }
    }
}

function convertToTemplateString(fixedString, dynamicIdentifier) {
    let resString = `({{)(${dynamicIdentifier})(\\..+)*}}`
    // 将动态部分的标识符添加到固定字符串中，以便后续替换
    let stringWithIdentifier = fixedString.replace(new RegExp(resString,'g'), function ($1,$2,$3,$4){
       return `[[props${$4?$4:''}]]`
    });
    return stringWithIdentifier;
}
