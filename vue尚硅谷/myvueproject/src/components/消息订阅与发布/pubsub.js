// 创建一个简单的发布/订阅对象
const pubsub = {};

// 存储所有的订阅者和他们的回调函数
pubsub.subscribers = {};

// 添加订阅者
pubsub.subscribe = function (eventName, callback,isOnce=false) {
  if (!this.subscribers[eventName]) {
    this.subscribers[eventName] = [];
  }
  callback.isOnce = isOnce;
  this.subscribers[eventName].push(callback);
};

// 发布消息
pubsub.publish = function (eventName, data) {
  if (!this.subscribers[eventName]) {
    return;
  }
  this.subscribers[eventName].forEach(function (callback) {
    callback(data);
  });
  this.subscribers[eventName] = this.subscribers[eventName].filter(item =>!item.isOnce)
};

// 示例用法
// 订阅消息
pubsub.subscribe('messageReceived', function (data) {
  console.log('Message received:', data);
});

// 发布消息
pubsub.publish('messageReceived', 'Hello, world!');

//取消订阅
pubsub.remove = function(eventName,callbackRemove){
    if(Array.isArray(this.subscribers[eventName])){
        if(!callbackRemove){
            delete this.subscribers[eventName]
        }else{
            this.subscribers[eventName] = this.subscribers[eventName].filter(item =>item !== callbackRemove)
        }
        
    }
}