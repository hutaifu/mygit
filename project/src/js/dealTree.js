/**
 * @name 递归处理树形结构树据
 * @param tree 根节点
 * @param callback 会调函数
 * @param parent 父节点
 */
export default function dealTree(tree, callback, parent,isStop) {
        if (typeof tree === "object" && !isStop) {
            callback(tree, parent,isStop);
            if (tree?.children?.length > 0) {
                tree.children.forEach(item => {
                    dealTree(item, callback, tree,isStop);
                })
            }
        }
}