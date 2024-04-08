## 01-什么叫进程

+ 进程是一个对立运行的程序，一个独立的任务，比如我们电脑上开启的任意一个软件，都可以看成是一个进程。
+ 电脑可以同时运行多个进程，开启多个任务，这个特点我们称为“多任务”。

## 02-什么叫线程

+ 一个线程可以看成是一个进程中单一的顺序控制流。
+ 一个进程中可以包含多个线程，比如qq这个进程，可以同时开启多个聊天窗口，一个聊天窗口可以看成是一个线程。
+ 我们目前编写的所有的程序，都是可以看成是一个独立的进程。但是我们这个程序中只有main方法在运行，main就是一个线程，我们的程序都是单线程的。
+ main方法我们一般称之为主线程。
+ 主线程的特点：
  + 是程序开始的地方
  + 产生其他线程的地方

## 03-创建线程

+ 方式一：继承Thread类

+ ```java
  public class TestThread extends Thread{
      public void run(){
          //这是另外一条线程的顺序控制流
          for (int i = 0; i < 100; i++) {
              System.out.println("这是线程1的内容");
          }
      }
  }
  //开启线程
  public class Testth01 {
      public static void main(String[] args) {


          //开启线程1
          TestThread thread01 = new TestThread();
          thread01.start();//回去执行run方法中的内容

  ```

+ 方式二：实现Runnbale接口,重写run方法

+ ```java
  public class TestRunnable implements Runnable{
      /**
       * When an object implementing interface <code>Runnable</code> is used
       * to create a thread, starting the thread causes the object's
       * <code>run</code> method to be called in that separately executing
       * thread.
       * <p>
       * The general contract of the method <code>run</code> is that it may
       * take any action whatsoever.
       *
       * @see Thread#run()
       */
      @Override
      public void run() {
          for (int i = 0; i < 1000; i++) {
              System.out.println("这是线程2");
          }
      }
  }
  //开启线程

  public class Testth01 {
      public static void main(String[] args) {

          //开启线程2
          TestRunnable testRunnable = new TestRunnable();
          Thread thread02 = new Thread(testRunnable);
          thread02.start();

  ```

+ 多线程运行：

  + 在一个程序中，有多个独立的顺序控制流，它们在宏观上是同时进行的
  + 比如上面的主线程，线程1，线程2是同时进行的
  + 在微观上，多个线程其实是交叉运行的，他们轮流占据cup，只有占据cpu的情况下，线程才是真正执行的状态。如果电脑是多核的，那么就是真正意义上的同时运行了。

+ Tread类和Runnable接口

  + 使用两种方式创建线程没有太大区别
  + 如果继承了thread类，那么就无法再继承其他类
  + 多使用实现接口的方式

## 04-线程的状态

+ 线程从被创建出来一直到运行结束，是一个完整的生命周期。再生命周期之间，线程的状态会发生变化。

  + 新建状态。（new）状态，刚刚通过new关键字创建完成时的状态。
  + 就绪状态（runnable），通过start方法开启后的状态，或者时等待别人执行的状态
  + 运行状态（running），占据cpuz执行代码的状态
  + 挂起状态（bleck），线程无法向下执行，比如线程中需要进行一个输入操作之才能继续运行，那么输入前的状态就是挂起状态
  + 死亡状态（dead），线程中的操作全部执行完，线程死亡。

+ 状态管理

  + 让线程让出cpu，从运行状态进人就绪状态。

  + ```java
    public class TestThread extends Thread{
        public void run(){
            //这是另外一条线程的顺序控制流
            for (int i = 0; i < 100; i++) {
                System.out.println("这是线程1的内容");
                //执行一次后，让出cpu
                Thread.yield();
            }
        }
    }

    ```

  + 让线程睡眠，从运行状态进人挂起状态

  + ```
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("这是线程2");

            //让线程二进入睡眠状态
            try {
                Thread.sleep(3000);//睡眠3秒种
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
    ```

    + 从睡眠结束后，先进入就绪状态

## 05-线程的执行顺序

+ 线程本身无法控制执行顺序，可以通过join方法让线程变成顺序执行

```java
public static void main(String[] args) {


    //开启线程1
    TestThread thread01 = new TestThread();
    thread01.start();//回去执行run方法中的内容

    //保证线程1一旦获取cpu后，全部执行完，才让出cpu
    try {
        thread01.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
```

## 06-线程的优先级

+ 每个线程都有一个默认的优先级，继承自分类

+ 线程优先级用数字表示，1代表最低，10代表最高

+ 默认都是5。

+ java本身提供了三种优先级常量

+ ```java
   public final static int MIN_PRIORITY = 1;

  /**
    * The default priority that is assigned to a thread.
    */
   public final static int NORM_PRIORITY = 5;

   /**
    * The maximum priority that a thread can have.
    */
   public final static int MAX_PRIORITY = 10;

  ```

+ 优先级的设置

```java
public static void main(String[] args) {


    //开启线程1
    TestThread thread01 = new TestThread();

    //设置Thread01优先级,优先级越高，获取cpu机会越多
    thread01.setPriority(thread01.MAX_PRIORITY);
    thread01.start();//回去执行run方法中的内容

```

+ ​
  + 一般情况下，优先级越高，越早结束。

## 07-多线程下的数据处理

+ 多线程在进行同一个对象的处理时，会出现第一个线程没有结束，然后第二个线程获取到某个对象，那么这时，第二个线程获取的数据是不准确的。
+ 我没需要保证某个线程在进行某个对象操作时，必须完成针对这个对像的所有操作才能让出cpu，让其他线程去操作这个对象。
+ Java中的每个对象，自带一个锁，无需去处理这个锁。
+ 我们只需要在线程中操作某个对象之前，先获取一下这个对象锁，然后等到全部操作完成了，我没再释放锁。

```java
public class ThreadAccount extends Thread {
    private Account account;//操作的银行账户
    private int money;//取款金额；
    public void run() {
        //获取对象的锁
        synchronized (account) {
            //取款操作
            if (account.getBalance() > money) {
                System.out.println(getName() + "可以取款并成功取款");
           /* try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
                account.setBalance(account.getBalance() - money);
                System.out.println("余额为：" + account.getBalance());
            } else {
                System.out.println("余额不足");
            }
            //取款操作
        }
    }


    public ThreadAccount(String name,Account account, int money) {
        super(name);  //线程的名字
        this.account = account;
        this.money = money;
    }
}

```

+ 再线程中先获取对象的锁，然后再对对象进行操作，可以只有当前线程的操作全部完成后，对象的锁才会被释放掉，其他线程才能继续操作这个对象。
+ 同步锁的释放
  + 如果同步块中的内容执行结束，自动释放同步锁
  + 当同步块中的内容出现error或者exception时，也会释放锁
  + 我们在同步块中调用了被锁对象的wait（）方法，那么也会释放锁。

```
try {
    //让当前线程释放掉account锁
    account.wait();
} catch (InterruptedException e) {
    e.printStackTrace();
}
```

+ ​		
  + 如果一个线程通过wait方法释放锁了，其他的线程依然无法获取对象
  + 我没需要在其他线程中执行notify（）   notifyAll（）方法才能获取对象的锁。
+ 死锁
  + 线程一需要操作两个对象，线程二也需要操作这两个对象。
  + 线程一获取了对象1的锁，线程二获取了对象二的锁
  + 线程1需要操作对象2，线程二需要对象一。
  + 这是死锁。