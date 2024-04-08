## 多态

### 01-为什么要使用多态

+ 如果不使用多态，那么作为主人需要掌握给不同的小宠物看病的技能，也就是声明很多方法，用于宠物的治疗，参数是不同的小动物类型。

+ ```java
  public class Master {
      public void cure(Dog dog){
          if (dog.getHealth() < 60){
              System.out.println("宠物小狗生病了，需要打针。");
              dog.setHealth(60);
          }
      }

      public void cure(Penguin penguin){
          if (penguin.getHealth() < 60){
              System.out.println("QQ生病了，需要吃药");
              penguin.setHealth(60);
          }
      }

  ```

  + 不使用多态，那么针对不同的小动物，主人要声明不同的治疗方法，主人类要经常改动。

+ 使用多态的方式

  + 在pet父类中声明一个抽象方法，规定宠物看病的方式，在不同的子类中实现，说明具体的看病方式。

  + ```java
    public class Pet{
      public abstract void cuer(); 
    }

    public class Dog extends Pet {

    @Override
        public void cure() {
            System.out.println("生病需要打针");
        }
    }

    public class Penguin extends Pet {
     @Override
        public void cure() {
            System.out.println("生病需要吃药");
        }
    ```

  + 主人类中，只需要掌握一种技能，就是带着宠物去看病即可

  + ```java
    public class Master {
        public void cure(Dog dog){
            if (dog.getHealth() < 60){
                System.out.println("宠物小狗生病了，需要打针。");
                dog.setHealth(60);
            }
        }

        public void cure(Penguin penguin){
            if (penguin.getHealth() < 60){
                System.out.println("QQ生病了，需要吃药");
                penguin.setHealth(60);
            }
        }

       //主人只需要带着宠物去看病即可
        //治疗方式在宠物对象本身里
       public void curePet(Pet pet){
           if (pet.getHealth() < 60){
               //调用宠物自己的治疗方法
               pet.cure();
               pet.setHealth(60);
           }
       }

    }

    ```

  + 创建宠物对象时，声明父类类型变量，创建子类对象，相当于把小狗或者小企鹅放到了一个宠物篮子中，那么主人带着这个篮子子去看病即可

  + ```java
    public class TestPet {
        public static void main(String[] args) {
            Dog dog = new Dog();
            dog.setHealth(50);

            Master master = new Master();
            master.cure(dog);

            Pet pet = new Dog();
            pet.setHealth(50);
            master.curePet(pet);

            Pet pet1 = new Penguin();
            pet1.setHealth(50);
            master.curePet(pet1);
        }
    }

    ```

    + curePet方法运行时，虚拟机会检测到这个pet中到底放了什么类型宠物，对应调用相应子类中的cure方法。

  + 使用了多态之后，如果要添加小动物，主人类无需改动。

### 02-多态的定义

+ 生活中的多态：同一件事物，因为条件不同，导致最终结果不同。
+ 程序中的 多态：同一个引用数据类型的变量，但是因为具体创建的实例类型不同，导致在执行相同操作时，结果不同。
+ 实现多态的步骤：
  + 要有方法的重写。
  + 创建对象时，声明父类，创建子类。
  + 如果去调用被重写的方法，结果不同。
    + 声明什么类型，就可以访问到什么类型中的属性或者方法
    + 创建什么类型，那么程序正真运行时就执行什么类中的方法。
+ 多态最直接的两种体系，
  + 方法的重载 overload
    + 同一个类中
    + 方法名相同
    + 参数列表必须不同，数量，顺序，类型
    + 和返回值，访问修饰符没有任何关系
  + 方法的重写 override
    + 发生在继承中，子类重写父类方法
    + 方法名相同，参数列表相同，返回值类型相同
      + public void show（）{}
    + 访问修饰符，不能比父类更严格。

### 03-类型转换

+ 通过多态创建的对象都是父类类型的，不能直接调用子类当中的特有方法

+ 如果需要调用 ，那么必须将父类类型的变量，转换为子类类型的变量

+ 大范围转换成小范围

+ ```java
  //pet是父类类型，不能直接调用子类中存在的方法
          //pet.play()

          //需要将pet中的小狗对象拿出来称为真正的小狗对象才能调用小狗的方法
          //大范围转小范围
          Dog dog1 = (Dog)pet;
          dog.playFlydisc();
  ```


          //在类型转换之前判断一些pet1中到底是什么类型。
          if (pet1 instanceof Dog) {
              Dog dog2 = (Dog) pet1;
          }else {
              Penguin penguin = (Penguin)pet1;
              penguin.swim();
          }
          
          if ("hello" instanceof String){
              
          }

  ```

+ 应用数据类型在转换之前需要先进行判断，判断某个变量是否属于某种类型

+ instanceof

+ 通过判断可以避免类型转换异常，ClassCastException

+ instanceof 应用

+ ```java
    
          if ("hello" instanceof String){
            //成立
              
          }

  ```

+ 所有的引用数据类型，都属于Object类型

+ ```java
  if ("hello" instanceof Object){

          }

          if (pet instanceof Object){

          }

  ```

### 04-包装类

+ java是面向对象的语言

+ 但基本数据类型不是面对对象的

+ 包装类的就是针对8种基本数据类型创建的类

  + byte  Byte
  + short Short
  + long Long
  + int    Integer
  + float Float
  + double  Double
  + char Character
  + boolean  Boolean

+ 包装类的对象也是

+ ```java
  public class Test01 {
      public static void main(String[] args) {
          int num = 10;
          Integer num01 = 10;
          //自动装箱，将int转换为integer
          num01.compareTo(num);
           //自动拆箱，将Integer 转换为int
          int num02= num01;
          
          if (num01 instanceof Object){
              
          }
          
          String str = "123";
          int  num03 = Integer.parseInt(str);
          double num04 = Double.parseDouble(str);
      }
  }

  ```

+ ​final关键字