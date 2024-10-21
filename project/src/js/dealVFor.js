function dealVFor(template, vue) {
    //去掉空白字符
    template = template.replace(/>\s+</g, '><').trim()
    //v-for,的处理
    //找到模板中含有v-for属性的标签字符串串
    const regex = /<[^>]*\bv-for\s*=\s*["']([^"']*)["'][^>]*>[\s\S]*?<\/[^>]*>/g;
    let result = regex.exec(template);
    while (result) {
        //v-for模板字符串
        let forString = result[0];
        //判断模板是否有闭合标签
        let closeTag = forString.substring(1, forString.search(" "))
        if (template.includes(`${forString}</${closeTag}>`)) {
            forString = `${forString}</${closeTag}>`
        }
        //得到v-for属性
        let forProp = result[1];
        console.log(forProp)
        //使用一个或者多个空格分割开
        let propsArr = forProp.split(/\s+/);
        console.log(propsArr)
        //得到for循环变量字符串
        let arrString = propsArr[2];
        let arrValue;
        //判断是否为数字
        if (Number(arrString)) {
            //如果是数字
            arrValue = Number(arrString);
        } else if (vue[arrString]) {
            //如果是父组件变量
            arrValue = vue[arrString];
        } else {
            //是字符串
            arrValue = arrString;
        }

        //得到item
        let itemString = propsArr[0].replace(/[()]/g, "").split(",")[0]
        //得到index或者key
        let indexString = propsArr[0].replace(/[()]/g, "").split(",")[1];
        console.log(itemString)
        console.log(indexString)
        console.log(forString)
        console.log(forProp)
        console.log(`v-for=${forProp}`)
        //声明模板数组
        let templateForArr = [];
        //去掉for字符串v-for属性
        let afterForString =   forString.replace(`v-for="${forProp}"`,"");
        //循环
        dealData(arrValue,(item,key)=>{
            //匹配:,v-bind,v-model开头的属性
            let rel = /(?<=(:)|(v-bind)|(v-model)|(v-slot)|(#slot)[a-zA-Z]*=).*/g






        })
        result = regex.exec(template)
    }


}


/**
 * @name 处理循环数据
 * @param data 循环数据
 * @param callback 回调函数
 */
function dealData(data, callback) {
    if (!callback || typeof callback !== "function"){
        return;
    }
    //判断数据类型
    if (Array.isArray(data) || typeof data === "string") {
        //如果是数组
        for (let i = 0; i < data.length; i++) {
                callback(data[i],i)
        }
    } else if (typeof data === "object") {
        //如果是对象
        Object.keys(data).forEach(key =>{
            callback(data[key],key)
        })

    }else if(typeof data === "number"){
        //如果是数字
        for (let i = 0; i < data; i++) {
            callback(i)
        }
    }else {
        //直接返回
        return;
    }
}


dealVFor(` <ul>
            <li v-for="(item,i) in products">
            
                <button @click="remove(index)">删除</button>
                </li>
        </ul>`, {products: [1, 2, 3, 3, 4, 4]})