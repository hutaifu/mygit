import {isExpression} from "@/js/myAddCompoent/jsExpress";
// 匹配事件绑定
export default function getEventBindings(obj,nativeOn,on,vue) {
    let keys = Object.keys(obj.attributes)
    let regex = /(?:@|v-on:)([a-zA-Z]+)(?:\.([\w.]+))*(?![\w.-]*\.native(?:$|\B))/;
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
                let jsFn = isExpression.bind(vue)(obj.attributes[item])
                if (jsFn) {
                    //如果是js表达式
                    fn = jsFn;
                }
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