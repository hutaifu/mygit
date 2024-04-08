//记录Promise的三种状态
const PENDING = 'pending';
const FULFILLED = 'fulfilled';
const REJECTED = 'rejected';

/**
 * 运行一个微队列任务
 * 把传递的函数放到微队列中
 * @param {FunCtion} callback 
 */
function runMicroTask(callback){
    //node环境
    if(typeof process !== 'undefined' && typeof process.nextTick === 'function'){
        return process.nextTick(callback)
    }
    else if(typeof MutationObserver === 'function'){
  //浏览器环境
        const ob = new MutationObserver(callback);
        const textNode = document.createTextNode('1');
        ob.observe(textNode,{characterData:true});
        textNode.data = '2';
    }
}

function isPromise(obj){
    return !!(obj && typeof obj === 'object' && typeof obj.then === 'function');
}


class MyPromise{

    /**
     * 创建一个promise
     * @param {*Function} executor 任务执行器，立即执行
     */
    constructor(executor){
        this._state = PENDING;//状态；
        this._value = undefined;//数据
        this._handlers = [];//处理函数形成的队列
        try{
            executor(this._resolve.bind(this),this._reject.bind(this));
        }catch(error){
            this._reject(error);
        }
      

    }
    /**
     * 
     * @param {Function} executor 添加的函数 
     * @param {String} state 该函数什么状态下执行
     * @param {Function} resolve 让then函数返回的promise成功
     * @param {Function} reject  让then函数返回的promise失败
     */
    _pushHandler(executor,state,resolve,reject){
        this._handlers.push({
            executor,
            state,
            resolve,
            reject
        })
    }

    /**
     * 
     * @returns 
     */
    _runHandlers(){
        if(this._state === PENDING){
            //目前仍在挂起
            return;
        }
        // for(const handler of this._handlers){
        //     this._runOneHandler(handler);
        //     this._handlers.shift();
        // }     //for  of循环里面写删除不行，容易造成指向问题
        while(this._handlers[0]){
            this._runOneHandler(this._handlers[0])
            this._handlers.shift();
        }
    }


    /**
     * 处理一个handler
     * @param {Object} handler 
     */
    _runOneHandler({executor,state,resolve,reject}){
        runMicroTask(() =>{
            if(this._state !== state){
                //状态不一致
                return;
            }
            if(typeof executor !== 'function'){
                //传递后续处理并非一个函数
                this._state === FULFILLED?resolve(this._value):reject(this._value)//跳过非函数的then,到下一个then,
                return;
            }
            try {
                const reslut = executor(this._value);
                if(isPromise(reslut)){
                    reslut.then(resolve,reject);//将返回值是promise进行处理，使返回值promise能够触发外面then方法返回的promise的resolve,reject事件。将里面的promise和外面的then连接起来
                }else{
                    resolve(reslut)//将返回值传给then生成的promsie,改变新生成的promsie的状态。,触发新promsie的事件队列，
                }
            } catch (error) {
                reject(error);
            }
        })

    }


/**
 * promese A+规范的then
 * @param {Function} onFulfilled 
 * @param {Function} onRejected 
 */
then(onFulfilled,onRejected){
    return new MyPromise((resolve,reject)=>{
        this._pushHandler(onFulfilled,FULFILLED,resolve,reject)
        this._pushHandler(onRejected,REJECTED,resolve,reject)
        this._runHandlers()//执行队列
    });
    //神奇的一步，将then方法返回的第二个promise的resolve,reject方法放到第一个函数的任队列里面，使得第一个函数的任务队列触发后，触发第二个promise的resove,rject
}




    /**
     * 
     * @param {String} newState 新状态 
     * @param {any} value 相关数据
     */
    _changeState(newState,value){
        if(this._state !== PENDING){
            //状态已被更改
            return;
        }
        this._state = newState;
        this._value = value;
        this._runHandlers();//状态变化，执行队列
    }



    /**
     * 标记当前任务完成
     */
    _resolve(data){
        console.log('完成',data)
        //改变状态和数据
        // this._state = FULFILLED;//直接调用，又是es6,class严格模式，this先声明才能用
        // this._value = data;
        this._changeState(FULFILLED,data)
    }

    /**
     * 标记当前任务失败
     */
    _reject(reason){
        console.log('失败',reason)
        //改变状态和数据
        // this._state = REJECTED;
        // this._value = reason;
        this._changeState(REJECTED,reason)
    }
}

let pro = new MyPromise((resolve,reject) =>{
    resolve(123);
}).then()

//Class下定义方法和构造函数将自动在严格模式下进行