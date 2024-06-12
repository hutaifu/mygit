function test() {
  return regeneratorRuntime.async(function test$(_context) {
    while (1) switch (_context.prev = _context.next) {
      case 0:
        _context.next = 2;
        return regeneratorRuntime.awrap(Promise.resolve(1));
      case 2:
        return _context.abrupt("return", _context.sent);
      case 3:
      case "end":
        return _context.stop();
    }
  }, null, null, null, Promise);
}
(function _callee() {
  var r;
  return regeneratorRuntime.async(function _callee$(_context2) {
    while (1) switch (_context2.prev = _context2.next) {
      case 0:
        _context2.next = 2;
        return regeneratorRuntime.awrap(test());
      case 2:
        r = _context2.sent;
        console.log(r);
      case 4:
      case "end":
        return _context2.stop();
    }
  }, null, null, null, Promise);
})();