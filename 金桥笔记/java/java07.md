03.二分法

+ 一组排好序的数组，需要去数组中查找是否包含某个数组，如果包含，输出下标，如果包含，则提示。
+ 二分法：首先先找到数组最中间的数值和目标数值比对，如果目标数值更大，那么我们可以缩小查找范围，从中间往后一个数值开始查找，在这个范围内继续寻找中间数值和目标值比对
+ Arrays.binarySearch(nums,500);