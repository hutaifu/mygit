import Vue from 'vue'


/**
 * @name 获取全局注册组件
 * @param id 组件vue注册id
 */
export default function getComponent(id) {
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