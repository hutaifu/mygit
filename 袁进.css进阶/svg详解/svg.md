1 #svg

svg:scalable vector graphics,可缩放的矢量图
1.该图片使用代码书写而成
2.缩放不会失真 （普通图片由像素点组成）
3.内容轻量


## 怎么使用

svg可以嵌入浏览器，也可以单独成为一个文件

xml语言，svg使用该语言定义

## 书写svg代码

### 矩形 rect

### 圆形 circle

### 椭圆  ellipse

### 线条 line

### 折线 polyline

### 多边形 polygon

### 路径 path  
M = moveto
L = lineto
H = horizontal lineto
V = vertical lineto
C = curveto
S = smooth curveto
Q = quadratic Bézier curve
T = smooth quadratic Bézier curveto
A = elliptical Arc
Z = closepath
直线命令
直线命令主要有以下几种：

M（moveto）：需要两个参数（x轴和y轴坐标，移动到的点的x轴和y轴的坐标
L（lineto）：需要两个参数（x轴和y轴坐标），它会在当前位置和最新的位置（L前面画笔所在的点）之间画一条线段。
H（horizontal lineto）：一个参数，标明在x轴移动到的位置，绘制水平线
V（vertical lineto）：一个参数，标明在y轴移动到的位置，绘制垂直线
Z（ closepath）：从当前点画一条直线到路径的起点
