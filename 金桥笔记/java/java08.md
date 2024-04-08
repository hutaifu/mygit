0.1，二重循环

+ 循环结构可以相互嵌套

+ ```
  Scanner input = new Scanner(System.in);
  //        每个班级学生成绩
          int[] scores = new int[4];
          int classCount = 3;
  //        和
          int sum = 0;
  //        平均分
          double avg = 0;
          for (int i = 0; i < classCount; i++) {
              sum =0;
              System.out.println("请录入第" + (i+1) + "个班级的成绩");
              for (int j = 0; j < scores.length; j++) {
                  System.out.println("第" + (j + 1) + "个学员的成绩:");
                  scores[j] = input.nextInt();
                  sum += scores[j];
              }
              avg = 1.0 * sum / scores.length;
              System.out.println("第" + (i+1) +"个班级的平均分是：" + avg);
          }
  ```

+ 外层循环班级，内层循环学生

+ 万层循环走一轮，内层循环走一遍

+ 外层循环用i，内层循环用j.

+ 循环尽量不超三层。

+ while，do-while，for可以互相嵌套。

  02.break 和 continue d 使用

+ 用在那个循环中，就控制哪个循环

+ break 用于跳出循环，去执行循环后的代码

+ continue用于提前结束本轮循环，去执行当前循环的变量迭代

  03.插入算法

+ 再一个排好序的数组中，插入一个新的元素，保证顺序。

+ ```
   String[] songs = {"Island","Ocean","Pretty","Sun"};
          System.out.println("插入的歌曲");
          for (int i = 0; i < songs.length; i++) {
              System.out.println(songs[i]+"\t");

          }
          Scanner input = new Scanner(System.in);
          System.out.println("请输入新歌曲");
          String newsong = input.next();
          String[] newsongs = new String[songs.length+1];
          for (int i = 0; i < songs.length; i++) {
              newsongs[i] = songs[i];
          }
          int index = newsongs.length-1;
          for (int i = 0; i < newsongs.length-1; i++) {
              if (newsongs[i].compareToIgnoreCase(newsong)>0){
                  index = i;
                  break;
              }
          }
          for (int i = newsongs.length-1; i >index  ; i--) {
              newsongs[i] = newsongs[i-1];

          }
          newsongs[index] =newsong;
          System.out.println("插入之后的歌曲是");
          for (int i = 0; i < newsongs.length; i++) {
              System.out.println(newsongs[i]+"\t");

          }
  ```

  + 思路
    + 新建数组，讲究数组的值依此复制过去，
    + 将新值和数组中的每个值依此进行比较，寻找目标位置
    + 目标位置原有的值以及之后所有的值都需要往后移动一个位置
    + 移动需要从后往前依此移动
    + 新值放到目标位置上，完成插入操作



## 04-数组的排序算法

+ Arrays.sort();

+ 冒泡排序

  + 将数组中相邻的两个数进行比较，将大数向后移动，如果前面的数比后面的数大，那么就两两交换，一轮下来最大的值会冒到最后，然后我们开始新一轮的两两比较，去找第二大的数值。

+ 选择排序

  + 打擂台循环操作

  + 默认将第一个位置上的数作为最小数，其他位置上的所有数都和这个最小数比较

  + 如果他们目前的最小数要小，那么和第一个位置上的数进行交换，一轮结束后

  + ```

            int[] nums = {45634, 54, 487, 45, 54, 41};
            for (int i = 0; i < nums.length-1; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] < nums[i]){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }

                }

            }
            System.out.println("排序后：");
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);

            }
    ```

  + ​