el-upload是一个基于Element UI组件库的文件上传组件，常用的参数如下：

1. action：上传地址，必填参数。
2. headers：上传请求的头部信息。
3. data：上传请求的附带参数。
4. name：上传文件的字段名，后台解析时需要用到。
5. with-credentials：上传请求是否携带cookie等凭证信息。
6. multiple：是否允许多文件上传。
7. accept：接受上传的文件类型，例如"image/*"。
8. before-upload：上传文件前的钩子函数，返回false或者Promise.reject()会中止上传。
9. on-progress：上传中的回调函数。
10. on-success：上传成功的回调函数。
11. on-error：上传失败的回调函数。
12. on-preview：点击文件列表中已上传的文件时的回调函数。
13. on-remove：从文件列表中移除已上传的文件时的回调函数。
14. file-list：已上传文件列表。
15. auto-upload：是否在选择文件后立即上传。
16. list-type：文件列表的显示方式，可选值为"text"、"picture"、"picture-card"。
17. disabled：是否禁用上传功能。
18. limit：上传文件数量的限制。
19. on-exceed：文件数量超出限制时的回调函数。
20. show-file-list：是否显示已上传文件列表。

以上是常用的el-upload参数，您可以根据具体需求使用不同的参数。