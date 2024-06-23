import Vue from "vue";

/**
 * @name js动态添加组件
 * @param vue 父组件vue
 * @param compoenent 要添加的组件
 * @param elString 挂载元素的选择器
 * @param templateString 模板字符串
 * @returns {*} 返回父组件的代理对象
 */
export function addComponent(vue, compoenent, elString, templateString) {
    if (typeof compoenent === "string") {
        compoenent = getComponent(compoenent);
    }
    let valueKey = [];
//原生事件不要加，
    //js表达式相关逻辑处理没有
    //作用域插槽总配置项
    //注入和提供的处理
    let collector = {};
    let parentVue = vue;
    vue = impleReactive(vue, collector);
    let scopedSlots = {};
    let myComp;
    //得到组件构造函数
    let Compoent = Vue.extend(compoenent);
    let tree = parseHTML(templateString);
    dealTree(tree[0], (obj, parent) => {
        //v-for,的处理
        //如果存在v-for
        /*        if (obj.attributes['v-for']){
                    let vForString = obj.attributes['v-for'];
                    let wrods = vForString.split(' ');
                    let itemString = '';
                    let indexString = '';
                    let arrString = '';
                    if (wrods[0].includes(",")){
                        wrods[0] = wrods[0].replace(/[(\)]/,"");
                        itemString = wrods[0].split(",")[0];
                        indexString = wrods[0].split(',')[1];
                    } else {
                        itemString = wrods[0].replace(/[(\)]/,"");
                    }
                    arrString = wrods[2];
                }*/
        //如果父组件是作用域插槽
        let slotScope = "";
        if (parent?.slotKey) {
            slotScope = parent.attributes[parent.slotKey]
        }
        //找到绑定事件
        let on = {};
        let props = {};
        let nativeOn = {};
        let key = "";
        let ref = "";
        let attrs = {};//普通html属性，而attrs设置的属性则以HTML属性的形式添加到元素上
        let topClass = {};
        let topstyle = {};
        let domProps = {};//dom属性，domProps设置的属性会直接映射到DOM元素上，这意味着，domProps可以设置一些特殊的属性，例如value、checked等，而attrs则适用于一般的HTML属性。
        if (obj.tagName === "template") {
            //插槽
            //是否有v-slot属性
            let sltoKey = Object.keys(obj.attributes).filter(item => /^(v-slot:)|#/.test(item))[0];
            let afterSltoKey = sltoKey?.replace(/^(v-slot:)|#/, "");
            if (afterSltoKey && afterSltoKey !== 'default') {
                //是否有参数
                if (obj.attributes[sltoKey]) {
                    //作用域插槽
                    scopedSlots[afterSltoKey] = afterSltoKey;
                    obj.slotKey = sltoKey;
                    obj._vnodeConfig = [obj.tagName, {}]
                } else {
                    //非传参插槽
                    obj._vnodeConfig = [obj.tagName, {slot: obj.attributes[sltoKey]}]
                }
            } else {
                //默认插槽
                obj._vnodeConfig = [obj.tagName, {slot: 'default'}]
            }
        }
        if (obj.attributes && obj.tagName !== 'template') {
            let keys = Object.keys(obj.attributes)
            // 匹配以 @ 或 v-on: 开头的事件绑定
            getEventBindings(/(?:@|v-on:)([a-zA-Z]+)(?:\.([\w.]+))*(?![\w.-]*\.native(?:$|\B))/);

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
                        //判断fn是否存在，不存在判断是否是js表达式
                        //判断js表达式
                        if (!fn) {
                            let jsFn = isExpression.bind(vue)(obj.attributes[item], collector)
                            if (jsFn) {
                                fn = jsFn;
                            }
                        } else {
                            //实现响应式
                            let key = obj.attributes[item];
                            (function (eventName) {
                                handleReactive(key, () => {
                                    //更新数据
                                    myComp.$off(eventName);
                                    myComp.$on(eventName, vue[key])
                                }, collector)
                            })(eventName)
                        }
                        //是否为原生事件
                        if (match[2] !== 'native') {
                            on[eventName] = fn?.bind(vue);
                        } else {
                            nativeOn[eventName] = fn?.bind(vue);
                        }
                    }
                });
            }

            // 获取prop属性并处理类型
            function getProp(optionsPropertyObj, rel) {

                let afterKeys = keys.filter(item => rel.test(item) && !/(ref|class|key|style)$/.test(item));
                afterKeys.forEach(item => {
                    let afterItem = item.replace(rel, "");
                    let value = obj.attributes[item];
                    // 处理布尔类型
                    if (value === "false") {
                        optionsPropertyObj[afterItem] = false;
                    } else if (value === "true") {
                        optionsPropertyObj[afterItem] = true;
                    } else if (!isNaN(Number(value))) { // 检查是否为数字
                        optionsPropertyObj[afterItem] = Number(value); // 转换为数字
                    } else {
                        // 其他情况，假设是绑定的属性
                        if (vue[value]) {
                            optionsPropertyObj[afterItem] = vue[value]; // 绑定属性
                            //实现响应式
                            let key = value;
                            (function (afterItem) {
                                handleReactive(key, () => {
                                    //更新数据
                                    myComp[afterItem] = vue[key]
                                }, collector)
                            })(afterItem)

                        } else {
                            setJsFn.bind(vue)(value, optionsPropertyObj, afterItem)
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
                    //实现响应式
                    let key = obj.attributes[refValue];

                    (function () {
                        handleReactive(key, () => {
                            //更新数据
                            myComp["ref"] = vue[key]
                        }, collector)
                    })()
                    ref = vue[obj.attributes[refValue]];
                } else {
                    let jsFn = isExpression.bind(vue)(obj.attributes[refValue], collector)
                    if (jsFn) {
                        //如果是js表达式
                        ref = jsFn;
                    } else {
                        ref = obj.attributes[refValue];
                    }
                }

            }
            let keyValue = keys.filter(item => /^(:|v-bind:)*key$/.test(item))[0];
            if (keyValue) {
                if (vue[obj.attributes[keyValue]]) {
                    let key = obj.attributes[keyValue];

                    (function () {
                        handleReactive(key, () => {
                            myComp['key'] = vue[key]
                        }, collector)
                    })();

                    key = vue[obj.attributes[keyValue]];
                } else {
                    let jsFn = isExpression.bind(vue)(obj.attributes[keyValue], collector)
                    if (jsFn) {
                        //如果是js表达式
                        key = jsFn;
                    } else {
                        key = obj.attributes[keyValue]
                    }
                }
            }
            //处理原生属性
            let domPropsString = ['checked', 'value', 'innerHTML']//dom属性数组，
            keys.filter(item => !/^(@|:|v-)/.test(item)).forEach(item => {
                if (!domPropsString.includes(item)) {
                    //如果不是dom属性，就是html属性
                    attrs[item] = obj.attributes[item]
                } else {
                    domProps[item] = obj.attributes[item]
                }
            })

            //处理顶层class
            function dealTopClassOrStyle(top, rel = /^(v-bind|:)class$/) {
                keys.filter(item => rel.test(item)).forEach(item => {
                    let value = obj.attributes[item]
                    //只考虑三种写法，对象，数组，变量，
                    //1.变量
                    if (!/^([{\[])/.test(value)) {
                        let rel = /^['"`].+['"`]$/
                        //判断是否为字符串
                        if (rel.test(value)) {
                            top.fn = () => value.replace(/['"`]/g, "")

                        } else {
                            //如果存在改变量
                            if (vue[value]) {
                                top.fn = function () {
                                    return vue[value]
                                };
                            }
                        }
                    } else
                    //2.对象
                    if (/^{/.test(value)) {
                        //如果是对象，“{  'sdf':kdslfj,"ksdf":"sdf"}”
                        //去掉大括号
                        value = value.replace(/[{}]/g, "");
                        //按照逗号分割
                        let arr = value.split(",");
                        top.fn = function () {
                            let myobj = {};
                            arr.forEach(item => {
                                let label = item.split(":")[0];
                                let labelValue = item.split(":")[1]
                                let isString = /^['"`].+['"`]$/
                                //判断是否为true
                                //不考虑表达式了
                                if (!isString.test(labelValue) && vue[labelValue]) {
                                    //实现响应式
                                    if (rel === /^(v-bind|:)class$/) {
                                        myobj[label] = !!vue[labelValue]
                                    } else {
                                        myobj[label] = vue[labelValue]
                                        //增加响应式
                                        handleReactive(labelValue, () => {
                                            myComp.$el.style[label] = vue[labelValue]
                                        }, collector)
                                    }
                                } else {
                                    if (rel === /^(v-bind|:)class$/) {
                                        if (labelValue === 'true') {
                                            myobj[label] = true;
                                        }
                                    } else {
                                        myobj[label] = labelValue;

                                    }
                                }
                            })
                            return myobj
                        }
                    } else
                    //3.数组
                    if (/^\[/.test(value)) {
                        //不考虑js表达式
                        //去掉中括号
                        value = value.replace(/[\[\]]/g, "");
                        let arr = value.split(",");
                        top.fn = function () {
                            let myarr = [];
                            arr.forEach(item => {
                                //判断是否为字符串
                                let rel = /^['"`].+['"`]$/
                                if (rel.test(item)) {
                                    //如果是字符串
                                    myarr.push(item.replace(/['"`]/g, ""))
                                } else {
                                    //判断是否为vue的属性
                                    if (vue[item]) {
                                        //实现响应式
                                        myarr.push(vue[item])
                                    }
                                }
                            })
                            return myarr;
                        }
                    }
                })
            }

            dealTopClassOrStyle(topClass, /^(v-bind|:)class$/);
            dealTopClassOrStyle(topstyle, /^(v-bind|:)style$/);


            //处理v-model属性
            function dealvModel() {
                keys.filter(item => /^v-model$/.test(item)).forEach(item => {
                    //存在v-model属性，
                    let value = obj.attributes[item];
                    if (jugeisStrign(value)) {
                        //如果是字符串,不做处理
                        // domProps.value = value;
                    } else {
                        //如果不是字符串
                        if (vue[value]) {
                            // props.value = this.value
                            //实现响应式
                            let key = value;
                            (function () {
                                handleReactive(key, () => {
                                    //更新数据
                                     myComp.value = vue[key]
                                }, collector)
                            })()
                            valueKey.push(value);
                        }
                        //双向绑定
                        on.input = inputvalue => {
                            vue[value] = inputvalue;
                        }
                    }
                })
            }

            dealvModel()

            let options = {on, props, nativeOn, attrs, ref, key, class: topClass, style: topstyle, domProps,};
            if (typeof ref === "function") {
                Object.defineProperty(options, 'ref', {
                    get() {
                        return ref();
                    }
                })
            }
            if (typeof key === "function") {
                Object.defineProperty(options, 'key', {
                    get() {
                        return key();
                    }
                })
            }
            if (typeof topClass.fn === "function") {
                Object.defineProperty(options, 'class', {
                    get() {
                        return topClass.fn();
                    }
                })

            }
            if (typeof topstyle.fn === "function") {
                Object.defineProperty(options, 'style', {
                    get() {
                        return topstyle.fn();
                    }
                })
            }
            if (typeof domProps.fn === "function") {
                Object.defineProperty(options, "domProps", {
                    get() {
                        return domProps.fn();
                    }
                })
            }


            if (Object.keys(on).length === 0) {
                delete options.on;
            }
            if (Object.keys(nativeOn).length === 0) {
                delete options.nativeOn;
            }
            //生成虚拟dom
            obj._vnodeConfig = [obj.tagName, options];
        } else if (obj.content) {
            //如果是文本节点，
            if (slotScope) {
                obj.content = convertToTemplateString(obj.content, slotScope)
            }
            obj._vnodeConfig = [obj.content];
        }
    })
    //拼接vnode
    let vNodesTree = concatVNodes(tree[0]);
    //挂载组件
    myComp = new Compoent({
        _isComponent: true, parent: parentVue, _parentVnode: vNodesTree
    }).$mount(elString);
    addWatch(parentVue, collector)
    // 触发更新
    setTimeout(valueKey.forEach(item => {
        vue[item] = vue[item]
    }), )


    return [myComp, vue];


    function concatVNodes(node, isOneLevel = true) {
        if (!node || !node._vnodeConfig) {
            return '';
        }
        if (typeof node._vnodeConfig[0] === "string") {
            //判断是否存在全局注册组件
            let rootVueCom = getComponent(node._vnodeConfig[0]);
            //如果不存在
            if (!rootVueCom) {
                if (isOneLevel) {
                    node._vnodeConfig[0] = compoenent
                }

            } else {
                //如果存在
                node._vnodeConfig[0] = rootVueCom;
            }
        } else {
            if (isOneLevel) {
                node._vnodeConfig[0] = compoenent;
            }
        }
        // let result = node._vnode;
        if (node.children && node.children.length > 0) {
            let childrenVnod = [];
            node.children.forEach(child => {
                childrenVnod.push(concatVNodes(child, false));
                if (Object.keys(scopedSlots)?.includes(node.slotKey?.replace(/^(v-slot:)|#/, ""))) {
                    scopedSlots[node.slotKey.replace(/^(v-slot:)|#/, "")] = (props) => {
                        let str = JSON.stringify(childrenVnod[childrenVnod.length - 1]).replace("[[", "${").replace("]]", "}");
                        return JSON.parse(eval(`\`${str}\``));
                    }
                }
            });
            if (isOneLevel && Object.keys(scopedSlots).length !== 0) {
                if (!node._vnodeConfig[1]) {
                    node._vnodeConfig[1] = {};
                }
                node._vnodeConfig[1].scopedSlots = scopedSlots;
            }
            return parentVue.$createElement(...node._vnodeConfig, childrenVnod)
        } else {
            //末级节点
            if (node._vnodeConfig.length !== 1) {
                return parentVue.$createElement(...node._vnodeConfig)
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

    // const regex = /<([a-zA-Z0-9]+)([^>]*)>|<\/([a-zA-Z0-9]+)>|([^<>]+)/g;
    const regex = /<([a-zA-Z0-9-]+)([^>]*)>|<\/([a-zA-Z0-9-]+)>|([^<>]+)/g;

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
function dealTree(tree, callback, parent) {
    {
        if (typeof tree === "object") {
            callback(tree, parent);
            if (tree?.children?.length > 0) {
                tree.children.forEach(item => {
                    dealTree(item, callback, tree);
                })
            }
        }
    }
}

function convertToTemplateString(fixedString, dynamicIdentifier) {
    let resString = `({{)(${dynamicIdentifier})(\\..+)*}}`
    // 将动态部分的标识符添加到固定字符串中，以便后续替换
    let stringWithIdentifier = fixedString.replace(new RegExp(resString, 'g'), function ($1, $2, $3, $4) {
        return `[[props${$4 ? $4 : ''}]]`
    });
    return stringWithIdentifier;
}


function isExpression(str, collector) {
    try {
        //判断是否包含空格
        let rel = /[ .()]/;
        if (!rel.test(str)) {
            return;
        }
        // 尝试将字符串解析为 JavaScript 代码
        let jsFn = new Function(`return ${str}`).bind(this);
        return dealFn(jsFn, collector).bind(this);
    } catch (e) {
        // 如果抛出错误，则不是有效的表达式
        return false;
    }
}

/**
 * @name 赋值js表达式
 * @param str js表达式字符串
 * @param obj 赋值对象
 * @param prop 赋值对象的属性
 * @returns {*}
 */
function setJsFn(str, obj, prop) {
    let jsFn = isExpression.bind(this)(str)
    if (jsFn) {
        //如果是js表达式，赋值给表达式结果
        Object.defineProperty(obj, prop, {
            get() {
                return jsFn();
            },
        })
    }
}

/**
 * @name 实现响应式
 * @param obj
 * @param collector 依赖收集对象
 */
function impleReactive(obj, collector) {
    //代理
    let proxy = new Proxy(obj, {
        get(target, p, receiver) {
            //进行依赖收集  ,不会弄
            if (collector._fn && typeof collector._fn === "function") {
                handleReactive(p, collector._fn, collector);
            }
            return Reflect.get(target, p)
        },
        set(target, p, value, receiver) {
            Reflect.set(target, p, value)
            //触发组件更新
            if (collector[p] && Array.isArray(collector[p])) {
                collector[p].forEach(item => {
                    item.bind(obj)()
                })
            }
            return true;
        },
        deleteProperty(target, p) {
            //触发组件更新

            return Reflect.deleteProperty(target, p)

        }
    });
    return proxy;
}


/**
 * @name 手动收集依赖
 * @param key 属性名
 * @param callback 触发回调
 * @param collector
 */
function handleReactive(key, callback, collector) {
    key = key.split(".")[0];
    if (collector[key]) {
        if (!collector[key].includes(callback) && !collector[key].map(item => item.toString()).includes(callback.toString())) {
            collector[key].push(callback);
        }
    } else {
        collector[key] = [callback];
    }
}


/**
 * @name 处理函数，让其变成一个响应式函数
 * @param fn 要处理的函数
 * @param collector 收集器
 */
function dealFn(fn, collector) {
    if (fn && typeof fn === "function") {
        let fnClone = function () {
            //记录原本函数
            collector._fn = fn;
            //执行原本函数
            fn();
            //去掉记录函数
            delete collector._fn;
        }.bind(this)
        return fnClone;
    }
}

/**
 * @name 创建父组件的监听
 * @param parentVue 父组件
 * @param collector 收集器
 */
function addWatch(parentVue, collector) {
    Object.keys(collector).forEach(key => {
        parentVue.$watch(key, {
            handler() {
                collector[key].forEach(fn => {
                    fn()
                })
            },
            deep: true,
        })
    })

}

/**
 * @name 获取全局注册组件
 * @param id 组件vue注册id
 */
function getComponent(id) {
    // 将短横线替换为驼峰命名法
    let componentName = id.replace(/-(\w)/g, function (match, p1) {
        return p1.toUpperCase();
    });

    // 获取全局注册的组件
    let component = Vue.component(componentName);

    // 如果组件不存在，替换首字母大写后再次尝试获取
    if (!component) {
        componentName = componentName.charAt(0).toUpperCase() + componentName.slice(1);
        component = Vue.component(componentName);
    }
    return component;
}

/**
 * 判断是否为双重引号字符串
 * @param str
 */
function jugeisStrign(str) {
    let isString = /^['"`].+['"`]$/
    return isString.test(str);
}