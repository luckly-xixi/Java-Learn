import java.util.Arrays;

abstract class Animal1 {

    public String name;

       public Animal1(String name) {
           this.name = name;
       }
   }

   interface IRunning {
    void run() ;
   }

   interface ISwimming {
    void swim();
   }

   interface IFlying {
    void fly();
   }
   class Dog1 extends Animal1 implements IRunning{
//必须先继承，再实现
       public Dog1(String name) {
           super(name);
       }

       @Override
       public void run() {
           System.out.println(name+"正在跑");
       }
   }


 /*  class Run1 {
    public void run() {
        System.out.println("奔跑");
    }
   }
 class Dog1 extends Animal1,Run1{
    //不支持多继承
       public Dog1(String name) {
           super(name);
       }
       public void run() {
           System.out.println(name+"正在跑");
       }
   }
*/

   class Fish1 extends Animal1 implements ISwimming {

       public Fish1(String name) {
           super(name);
       }

       @Override
       public void swim() {
           System.out.println(name+"正在水里游");
       }
   }

   class Bird1 extends Animal1 implements IFlying {

       public Bird1(String name) {
           super(name);
       }

       @Override
       public void fly() {
           System.out.println(name+"正在天空翱翔");
       }
   }

   class Duck1 extends Animal1 implements IFlying,IRunning,ISwimming {
    //一个类只能继承一个父类, 但可以同时实现多种接口
       public Duck1(String name) {
           super(name);
       }

       @Override
       public void run() {
           System.out.println(name+"可以在地上用掌跑");
       }

       @Override
       public void swim() {
           System.out.println(name+"可以用翅膀短暂的飞");
       }

       @Override
       public void fly() {
           System.out.println(name+"可以在水面上游");
       }
   }

   //接口合并（复用）extends关键字
   interface IAmphibious extends IRunning,ISwimming {
       @Override
       default void run() {
           System.out.println("两栖类的奔跑");
       }

       @Override
       default void swim() {
           System.out.println("两栖类的游泳");
       }
   }

   //设计问题两个接口的方法都相同
   interface A {
       void giao();
   }
   interface E {
       void giao();
   }
   class G implements A,E {
       @Override
       public void giao() {
           System.out.println("一哩我哩giao");
       }
   }

   class Student1 implements Comparable<Student1>{
       public String name;
       public int age;
       public int score;

       public Student1(String name, int age, int score) {
           this.name = name;
           this.age = age;
           this.score = score;
       }

       @Override
       public String toString() {
           return "Student1{" +
                   "name='" + name + '\'' +
                   ", age=" + age +
                   ", score=" + score +
                   '}';
       }

       @Override
       public int compareTo(Student1 o) {
           if(this.name.compareTo(o.name) > 0) {
               return 1;
           }else if (this.name.compareTo(o.name) < 0) {
               return -1;
           }else {
               return 0;
           }

           //          if(this.age > age) {
//              return 1;
//          }else if(this.age < age) {
//              return -1;
//          }else {
//              return 0;
//          }
       }

   }


   public class branch9 {

       public static void sort (Comparable[] array) {
           for (int i = 0; i < array.length-1; i++) {
               for (int j = 0; j < array.length-1-i; j++) {

                   if(array[j].compareTo(array[j+1]) > 0) {
                       Comparable tmp = array[j];
                       array[j] = array[j+1];
                       array[j+1] = tmp;
                   }

               }
           }
       }

       public static void main(String[] args) {
           Student1[] student1 = new Student1[3];
           student1[0] = new Student1("法外狂徒张三",23,99);
           student1[1] = new Student1("无敌坤坤",23,1);
           student1[2] = new Student1("小黑子",23,89);

           Arrays.sort(student1);
           System.out.println(Arrays.toString(student1));
           System.out.println(student1[0].compareTo(student1[1]));
           sort(student1);
           System.out.println(Arrays.toString(student1));
       }

       public static void main2(String[] args) {
           G g = new G();
           g.giao();
       }

//撇开了类型
       public static void walk(IRunning iRunning) {
           iRunning.run();
       }

       public static void swim(ISwimming iSwimming) {
           iSwimming.swim();
       }
        public static void main1(String[] args) {
            walk(new Dog1("菜狗"));
            walk(new Duck1("涡轮增鸭"));
            System.out.println("============");

            swim(new Duck1("丑小鸭"));
            swim(new Fish1("红鲤鱼与绿鲤鱼"));
        }
}
