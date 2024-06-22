import Vue from 'vue'
/**
 * @name  js中动态添加组件
 * @param parentVue
 * @param addComponent
 * @param elString
 * @param template
 */
export default function addComponent(parentVue,addComponent,elString,template) {
    //判断传入的组件是否为对象
    let addComponentConstr;//组件构造函数
    if (typeof addComponent === "object"){
        //如果是对象生成对应的组件构造函数
        addComponentConstr = Vue.extend(addComponent)
    }
    if (typeof addComponent === "function"){
        //如果是构造函数
        addComponentConstr = addComponent;
    }

   /* new addComponentConstr({ _isComponent: true, parent: parentVue, _parentVnode:});*/


























}