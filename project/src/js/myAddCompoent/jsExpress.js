export function isExpression(str,scope = {}) {
    try {
        //判断是否包含空格
        let rel = /[ .()]/;
        if (!rel.test(str) && !Object.keys(scope).includes(str)) {
            return;
        }
        // 尝试将字符串解析为 JavaScript 代码
            let jsFn = new Function(...Object.keys(this),...Object.keys(scope),`return ${str}`).bind(this);

        return jsFn;
    } catch (e) {
        // 如果抛出错误，则不是有效的表达式
        return false;
    }
}