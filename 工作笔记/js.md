atob() 函数接收一个六位二进制的ascll字符 ，即base64位字符串，返回一个八位的二进制ascll字符串，获取返回字符串每个字符的二进制编码对应的数字，放到数组Uint8Array中，再把Uint8Array放到new Bolb中就能获取文件原始的二进制数据。

相对于bota()函数接收一个八位二进制ascll字符 ，返回六位二进制字符，即base64编码。