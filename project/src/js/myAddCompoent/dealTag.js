/**
 * @name 处理vue模板，解析为抽象语法树，ast
 * @param htmlString
 * @returns {Array}
 */
export default function parseHTML(htmlString) {
    const stack = [];
    const root = {tagName: 'root', attributes: {}, children: []};
    let current = root;
    stack.push(current);

    const regex = /<([a-zA-Z0-9-]+)([^>]*)>|<\/([a-zA-Z0-9-]+)>|([^<>]+)/g;

    let match;

    while ((match = regex.exec(htmlString)) !== null) {
        const [text, openTag, attributes, closeTag, plainText] = match;
        if (openTag) {
            const node = {tagName: openTag, attributes: parseAttributes(attributes), children: []};
            current.children.push(node);
            stack.push(node);
            current = node;
        } else if (closeTag) {
            stack.pop();
            current = stack[stack.length - 1];
        } else if (plainText && plainText.trim()) {
            current.children.push({content: plainText.trim()});
        }
    }

    return root.children;
}


function parseAttributes(attributeString) {
    const attributes = {};
    const attrRegex = /([^=\s]+)\s*=\s*(['"])(.*?)\2|\b([^=\s]+)\b/g;

    let match;
    while ((match = attrRegex.exec(attributeString)) !== null) {
        const [, name, quote, value] = match;
        if (name && value !== undefined) {
            attributes[name] = value;
        } else if (name) {
            // 处理没有指定值的属性
            attributes[name] = true;
        }
    }

    return attributes;
}