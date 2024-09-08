import Vue from 'vue'
import getComponent from "@/js/myAddCompoent/getComponent";
import parseHTML from "@/js/myAddCompoent/dealTag";
import dealTree from "@/js/myAddCompoent/dealTree";
import dealVFor from "@/js/myAddCompoent/dealVFor";
import dealTemplateObj from "@/js/myAddCompoent/dealTemplateObj";
import getEventBindings from "@/js/myAddCompoent/dealEventBinds"
import getProp from "@/js/myAddCompoent/dealProp";
import dealRef from "@/js/myAddCompoent/dealRef";
import dealKey from "@/js/myAddCompoent/dealkey";
import dealClassAndStyle from "@/js/myAddCompoent/dealClassAndStyle";
import dealDomProps from "@/js/myAddCompoent/dealDomProps";
import dealvModel from "@/js/myAddCompoent/dealModel";
import convertToTemplateString from "@/js/myAddCompoent/dealTemplateString";
import concatVNodes from "@/js/myAddCompoent/concatAndProductVNodes";

/**
 * @name  js中动态添加组件
 * @param parentVue
 * @param addComponent
 * @param id
 * @param template
 */
export default function addComponent(parentVue, addComponent, id, template) {
    //判断传入的组件是否为对象
    let AddComponentConstr;//组件构造函数
    if (typeof addComponent === "object") {
        //如果是对象生成对应的组件构造函数
        AddComponentConstr = Vue.extend(addComponent)
    }
    if (typeof addComponent === "function") {
        //如果是构造函数
        AddComponentConstr = addComponent;
    }
    //如果是字符串，判断有无对全局注册组件
    if (typeof addComponent === "string") {
        //可能是否字符串，可能是组件构造函数
        AddComponentConstr = getComponent(addComponent)
    }

    //记录是否第一次，v-model第一次不会更新，？？？
    let isOnce = true;
    let modelKey = [];
    //解析模板字符串
    //判断是否含有v-for属性
    let tree;
    tree = parseHTML(template);
    //形成闭包
    let render = () => {
        let scopedSlots = {};
        dealTree(tree[0], (obj, parent) => {
            //处理v-for语法
             dealVFor(obj)
            //如果父节点是作用域插槽
            let slotScope = "";
            if (parent?.slotKey) {
                slotScope = parent.attributes[parent.slotKey]
            }
            //声明配置项
            let model = {};
            let on = {};//事件
            let nativeOn = {};//原生事件
            let key = "";//key
            let ref = "";//ref
            let attrs = {};//普通html属性，而attrs设置的属性则以HTML属性的形式添加到元素上,prop属性也在这里面
            let topClass = {};//顶层class
            let topstyle = {};//顶层style
            let domProps = {};//dom属性，domProps设置的属性会直接映射到DOM元素上，这意味着，domProps可以设置一些特殊的属性，例如value、checked等，而attrs则适用于一般的HTML属性。
            //处理插槽
            dealTemplateObj(obj, scopedSlots);
            //处理非插槽
            if (obj.attributes && obj.tagName !== 'template') {
                //处理事件绑定
                getEventBindings(obj, nativeOn, on, parentVue);
                //处理props
                getProp(attrs, parentVue, obj)
                //处理ref
                ref = dealRef(obj, parentVue)
                //处理key
                key = dealKey(parentVue, obj)
                //处理class和html
                dealClassAndStyle(obj, topClass, topstyle, parentVue);
                if (topstyle.value) {
                    topstyle = topstyle.value;
                }
                if (topClass.value) {
                    topClass = topClass.value;
                }
                //处理原生事件属性
                dealDomProps(obj, attrs, domProps);
                //处理双向绑定
                dealvModel(obj, parentVue, model, modelKey)
                //合并配置项
                let options = {on, nativeOn, attrs, ref, key, class: topClass, style: topstyle, domProps, model};
                if (Object.keys(on).length === 0) {
                    delete options.on;
                }
                if (Object.keys(nativeOn).length === 0) {
                    delete options.nativeOn;
                }
                if (Object.keys(model).length === 0) {
                    delete options.model;
                }
                //合并h函数参数
                obj._vnodeConfig = [obj.tagName, options];
            } else if (obj.content) {
                //如果是文本节点，
                if (slotScope) {
                    obj.content = convertToTemplateString(obj.content, slotScope)
                }
                obj._vnodeConfig = [obj.content];
            }
        })
        //得到虚拟节点
        let vNodesTree = concatVNodes(tree[0], AddComponentConstr, scopedSlots, parentVue);
        return vNodesTree;
    }
    //得到一次渲染虚拟节点
    let vNode = render();

    //需要调用一次extend方法，如果不调用，ref就会绑定在在原生dom元素上面，我也不知道为啥，奇奇怪怪的
        AddComponentConstr = Vue.extend(AddComponentConstr)

    //挂载组件
    let myComp = new AddComponentConstr({
        _isComponent: true, parent: parentVue, _parentVnode: vNode
    }).$mount(`#${id}`);

    if (isOnce) {
        if (modelKey.length !== 0) {
            setTimeout(() => {
                //触发第一次v-model更新，离谱
                modelKey.forEach(key => {
                    let value = parentVue[key]
                    parentVue[key] = "";
                    setTimeout(() => {
                        parentVue[key] = value
                    })
                })
            })
        }
        isOnce = false;
    }


    function jugeidVnode(id, vnode) {
        if (vnode?.data?.attrs?.id === id) {
            return true;
        } else {
            return false;
        }
    }

    //替换虚拟节点
    function replaceVNode(oringVNode,dealafterVNode){
        //替换当前组件的虚拟节点
        dealTree(oringVNode, (vnode, parent, isStop) => {
            if (jugeidVnode(id, vnode)) {
                //替换掉当前虚拟节点
                let index = parent.children.findIndex(item => item === vnode)
                parent.children[index] = dealafterVNode;
                isStop = true;
            }
        }, null, false)
    }

    replaceVNode(parentVue._vnode,vNode)


    //绑定虚拟节点的组件实例
    vNode.componentInstance = myComp;
    //替换当前组件的渲染方法
    let _render = parentVue.$options.render.bind(parentVue);
    parentVue.$options.render = () => {
        let _vnode = _render();
        //绑定虚拟节点的组件实例
        _vnode.componentInstance = myComp;
        let myComVnode = render();
        replaceVNode(_vnode,myComVnode)
        return _vnode;
    }
    return myComp;
}