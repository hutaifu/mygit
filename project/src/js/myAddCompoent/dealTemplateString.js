export default function convertToTemplateString(fixedString, dynamicIdentifier) {
    let resString = `({{)(${dynamicIdentifier})(\\..+)*}}`
    // 将动态部分的标识符添加到固定字符串中，以便后续替换
    let stringWithIdentifier = fixedString.replace(new RegExp(resString, 'g'), function ($1, $2, $3, $4) {
        return `[[props${$4 ? $4 : ''}]]`
    });
    return stringWithIdentifier;
}