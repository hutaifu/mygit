export default function dealClassAndStyle(obj, topClass, topStyle, vue) {
    let keys = Object.keys(obj.attributes)
    dealTopClassOrStyle(topClass, /^(v-bind|:)class$/, keys, obj, vue);
    dealTopClassOrStyle(topStyle, /^(v-bind|:)style$/, keys, obj, vue);
}

//处理顶层class
function dealTopClassOrStyle(top, rel = /^(v-bind|:)class$/, keys, obj, vue) {
    keys.filter(item => rel.test(item)).forEach(item => {
        let value = obj.attributes[item]
        //只考虑三种写法，对象，数组，变量，
        //1.变量
        if (!/^([{\[])/.test(value)) {
            let rel = /^['"`].+['"`]$/
            //判断是否为字符串
            if (rel.test(value)) {
                top = value.replace(/['"`]/g, "")

            } else {
                //如果存在改变量
                if (vue[value]) {
                    top.type = 'string';
                    top.value = vue[value]
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
            let myobj = top;
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
        } else
            //3.数组
        if (/^\[/.test(value)) {
            //不考虑js表达式
            //去掉中括号
            value = value.replace(/[\[\]]/g, "");
            let arr = value.split(",");
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
            top.value = myarr;
            top.type = "array";

        }
    })
}