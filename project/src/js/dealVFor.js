
export default function dealVFor(template){
    //去掉空白字符
    template = template.replace(/>\s+</g, '><').trim()
    //v-for,的处理
    //找到模板中含有v-for属性的标签字符串串
    const regex = /<[^>]*\bv-for\s*=\s*["']([^"']*)["'][^>]*>[\s\S]*?<\/[^>]*>/g;
    let result = regex.exec(template);
    while (result){
        //v-for模板字符串
        let forString = result[0];
        //判断模板是否有闭合标签
        let closeTag = forString.substring(1,forString.search(" "))
        if (template.includes(`${forString}</${closeTag}>`)){
            forString = `${forString}</${closeTag}>`
        }
        //得到v-for属性
        let forProp = result[1];
        console.log(forProp)
        //使用一个或者多个空格分割开
        let propsArr = forProp.split(/\s+/);
        console.log(propsArr)
        //得到item
        let itemString = propsArr[0].replace(/[()]/g,"").split(",")[0]
        let indexString = propsArr[0].replace(/[()]/g,"").split(",")[1];
        console.log(itemString)
        console.log(indexString)
        //得到for循环变量字符串
        let arrString = propsArr[2];
        result = regex.exec(template)
    }


}

dealVFor(` <ul>
            <li v-for="(item,i) in products">
            
                <button @click="remove(index)">删除</button>
                </li>
        </ul>`)