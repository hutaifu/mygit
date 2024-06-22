// 获取prop属性并处理类型
function getProp(optionsPropertyObj,vue) {
    rel = /^(:|v-bind:)/;
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