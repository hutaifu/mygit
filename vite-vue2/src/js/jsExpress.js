export function isExpression(str, collector) {
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
export function setJsFn(str, obj, prop) {
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