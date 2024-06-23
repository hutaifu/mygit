/**
 * 判断是否为双重引号字符串
 * @param str
 */
export default function jugeisStrign(str) {
    let isString = /^['"`].+['"`]$/
    return isString.test(str);
}