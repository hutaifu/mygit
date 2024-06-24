/**
 * @name 实现响应式
 * @param obj
 * @param collector 依赖收集对象
 */
export function impleReactive(obj, collector) {
    //代理
    let proxy = new Proxy(obj, {
        get(target, p, receiver) {
            //进行依赖收集  ,不会弄
            if (collector._fn && typeof collector._fn === "function") {
                handleReactive(p, collector._fn, collector);
            }
            return Reflect.get(target, p)
        },
        set(target, p, value, receiver) {
            Reflect.set(target, p, value)
            //触发组件更新
            if (collector[p] && Array.isArray(collector[p])) {
                collector[p].forEach(item => {
                    item.bind(obj)()
                })
            }
            return true;
        },
        deleteProperty(target, p) {
            //触发组件更新

            return Reflect.deleteProperty(target, p)

        }
    });
    return proxy;
}

/**
 * @name 手动收集依赖
 * @param key 属性名
 * @param callback 触发回调
 * @param collector
 */
export function handleReactive(key, callback, collector) {
    key = key.split(".")[0];
    if (collector[key]) {
        if (!collector[key].includes(callback) && !collector[key].map(item => item.toString()).includes(callback.toString())) {
            collector[key].push(callback);
        }
    } else {
        collector[key] = [callback];
    }
}

/**
 * @name 处理函数，让其变成一个响应式函数
 * @param fn 要处理的函数
 * @param collector 收集器
 */
export function dealFn(fn, collector) {
    if (fn && typeof fn === "function") {
        let fnClone = function () {
            //记录原本函数
            collector._fn = fn;
            //执行原本函数
            fn();
            //去掉记录函数
            delete collector._fn;
        }.bind(this)
        return fnClone;
    }
}

/**
 * @name 创建父组件的监听
 * @param parentVue 父组件
 * @param collector 收集器
 */
export function addWatch(parentVue, collector) {
    Object.keys(collector).forEach(key => {
        parentVue.$watch(key, {
            handler() {
                collector[key].forEach(fn => {
                    fn()
                })
            },
            deep: true,
        })
    })

}