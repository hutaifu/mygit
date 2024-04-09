import Vue from "vue";

export function addComponent(vue, compoenent, elString, templateString) {
    let myComp;
    //得到组件构造函数
    let Compoent = Vue.extend(compoenent);
    let tree = parseHTML(templateString);
    dealTree(tree, (obj, parent) => {
        //找到绑定事件
        let on = {};
        let props = {};
        let nativeOn = {};
        let key = "";
        let ref = "";
        let attrs = {};

        if (obj.attributes) {
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
            if (JSON.stringify(on) === JSON.stringify({})) {
                delete options.on;
            }
            if (JSON.stringify(nativeOn) === JSON.stringify({})) {
                delete options.nativeOn;
            }
            //生成虚拟dom
            obj._vnodeConfig = [obj.tagName, options];
        }
        if (obj.content) {
            //如果是文本节点，
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
            });
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
function dealTree(tree, callback) {
    if (Array.isArray(tree) && tree.length !== 0) {
        tree.forEach(item => {
            callback(item, tree);
            if (item?.children?.length > 0) {
                dealTree(item.children, callback);
            }
        })
    }
}
