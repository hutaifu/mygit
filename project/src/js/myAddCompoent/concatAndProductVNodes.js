import getComponent from "@/js/myAddCompoent/getComponent";
export default function concatVNodes(node,compoenent,scopedSlots,parentVue,isOneLevel = true) {
    if (!node || !node._vnodeConfig) {
        return '';
    }
    //如果是第一层级
    if (compoenent){
        node._vnodeConfig[0] = compoenent;
    }else {
        //不是第一层级，并且标签名称是字符串
        if ( !isOneLevel  && typeof node._vnodeConfig[0] === "string") {
            //如果标签名称是字符串
            //标签名称
            //判断是否存在全局注册组件
            let rootVueCom = getComponent(node._vnodeConfig[0]);
            //如果不存在
                node._vnodeConfig[0] = rootVueCom;

        }
    }
    // let result = node._vnode;
    if (node.children && node.children.length > 0) {
        let childrenVnod = [];
        node.children.forEach(child => {
            childrenVnod.push(concatVNodes(child,null,scopedSlots,parentVue,false));
            if (Object.keys(scopedSlots)?.includes(node.slotKey?.replace(/^(v-slot:)|#/,""))) {
                scopedSlots[node.slotKey.replace(/^(v-slot:)|#/, "")] = (props) => {
                    let str = JSON.stringify(childrenVnod[childrenVnod.length - 1]).replace("[[", "${").replace("]]", "}");
                    return JSON.parse(eval(`\`${str}\``));
                }
            }
        });
        if (isOneLevel && Object.keys(scopedSlots).length !== 0) {
            if (!node._vnodeConfig[1]) {
                node._vnodeConfig[1] = {};
            }
            node._vnodeConfig[1].scopedSlots = scopedSlots;
        }
        return parentVue.$createElement(...node._vnodeConfig, childrenVnod)
    } else {
        //末级节点
        if (node._vnodeConfig.length !== 1) {
            return parentVue.$createElement(...node._vnodeConfig)
        } else {
            return node._vnodeConfig;
        }
    }
}