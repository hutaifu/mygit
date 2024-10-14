import getComponent from "@/js/myAddCompoent/getComponent";
import {hasSymbol} from "vue";

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
        //如果存在vFor属性
        if (node._vnodeConfig.vFor){
            return renderList(node._vnodeConfig.vFor.arr,function (item,index) {
                return parentVue.$createElement(...node._vnodeConfig, childrenVnod);
            })
        }


        return parentVue.$createElement(...node._vnodeConfig, childrenVnod)
    } else {
        //末级节点
        if (node._vnodeConfig.length !== 1) {
            //如果存在vFor属性
            if (node._vnodeConfig.vFor){
                return renderList(node._vnodeConfig.vFor.arr,function (item,index) {
                    return parentVue.$createElement(...node._vnodeConfig);
                })
            }

            return parentVue.$createElement(...node._vnodeConfig)
        } else {
            return node._vnodeConfig;
        }
    }
}


/**
 * Runtime helper for rendering v-for lists.
 */
function renderList(val, render) {
    var ret = null, i, l, keys, key;
    if (Array.isArray(val) || typeof val === 'string') {
        ret = new Array(val.length);
        for (i = 0,
                 l = val.length; i < l; i++) {
            ret[i] = render(val[i], i);
        }
    } else if (typeof val === 'number') {
        ret = new Array(val);
        for (i = 0; i < val; i++) {
            ret[i] = render(i + 1, i);
        }
    } else if (isObject(val)) {
        if (hasSymbol && val[Symbol.iterator]) {
            ret = [];
            var iterator = val[Symbol.iterator]();
            var result = iterator.next();
            while (!result.done) {
                ret.push(render(result.value, ret.length));
                result = iterator.next();
            }
        } else {
            keys = Object.keys(val);
            ret = new Array(keys.length);
            for (i = 0,
                     l = keys.length; i < l; i++) {
                key = keys[i];
                ret[i] = render(val[key], key, i);
            }
        }
    }
    if (!isDef(ret)) {
        ret = [];
    }
    ret._isVList = true;
    return ret;
}

function isObject(obj) {
    return obj !== null && typeof obj === 'object';
}

function isDef(v) {
    return v !== undefined && v !== null;
}