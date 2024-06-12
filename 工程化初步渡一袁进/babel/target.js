"use strict";

require("core-js/modules/es.promise.js");
var _obj$foo;
const obj = {};
obj === null || obj === void 0 || (_obj$foo = obj.foo) === null || _obj$foo === void 0 || (_obj$foo = _obj$foo.bar) === null || _obj$foo === void 0 || _obj$foo.baz; //undefined

async function test() {
  return await Promise.resolve(1);
}
(async () => {
  const r = await test();
  console.log(r);
})();
