import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

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

   //Comparable的了解
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

/*           if(this.age > age) {
              return 1;
          }else if(this.age < age) {
              return -1;
          }else {
              return 0;
          }*/
//          return this.age - o.age;
       }

   }

//Comparator是比较器
   class AgeComparator implements Comparator<Student1> {

       @Override
       public int compare(Student1 o1, Student1 o2) {
           return o1.age - o1.age;
       }
   }

    class ScoreComparator implements Comparator<Student1> {
        @Override
        public int compare(Student1 o1, Student1 o2) {
            return o1.score - o2.score;
        }
    }

    class NameComparator implements Comparator<Student1> {
        @Override
        public int compare(Student1 o1, Student1 o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    //Cloneable的了解
    class Animal2 implements Cloneable {

        public String name;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    //深浅拷贝
    class Money implements Cloneable{
        public double m = 99.99;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    class Person1 implements Cloneable{

    public Money money = new Money();
    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        //只是克隆person对象
        Person1 person = (Person1) super.clone();
        //克隆了persong对象里面的money对象
        person.money = (Money) this.money.clone();

        return person;
    }

    public void fun1() {}
    public void fun2() {}
    public void fun3() {}
}

class Persons{
    private String name ;
    private int age ;
    public Persons(String name, int age) {
        this.age = age ;
        this.name = name ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons = (Persons) o;
        return age == persons.age && Objects.equals(name, persons.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false ;
//        }
//        //指的是同一个对象
//        if(this == obj) {
//            return true ;
//        }
//// 不是Person类对象
//        if (!(obj instanceof Persons)) {
//            return false ;
//        }
//
//        Persons person = (Persons) obj ; // 向下转型，比较属性值
//        return this.name.equals(person.name) && this.age==person.age ;
//    }
}

   public class branch9 {
        //hashCode 的介绍
       public static void main(String[] args) {
           Persons p1 = new Persons("giao", 20) ;
           Persons p2 = new Persons("giao", 20) ;
           //我们希望p1和p2这两个对象，放到同一个位置
           System.out.println(p1.hashCode());
           System.out.println(p2.hashCode());
       }

        //equals重写
       public static void main8(String[] args) {
           Persons p1 = new Persons("giao", 20) ;
           Persons p2 = new Persons("giao", 20) ;
           int a = 10;
           int b = 10;
           System.out.println(a == b);       // 输出true
           System.out.println(p1 == p2);      // 输出false
           System.out.println(p1.equals(p2));    // 输出false
       }

       //匿名对象
       public static void main7(String[] args) {
           Person1 p = new Person1();
           p.fun1();
           p.fun2();
           p.fun3();
           System.out.println("--------------");
           new Person1().fun1();
           new Person1().fun2();
           new Person1().fun3();
       }

       public static void main6(String[] args) throws CloneNotSupportedException {
           Person1 person1 = new Person1();
           Person1 person2 = (Person1) person1.clone();
           System.out.println("通过person2修改前的结果");
           System.out.println(person1.money.m);
           System.out.println(person2.money.m);
           person2.money.m = 13.6;
           System.out.println("通过person2修改后的结果");
           System.out.println(person1.money.m);
           System.out.println(person2.money.m);
       }

       public static void main5(String[] args) throws CloneNotSupportedException {
        Animal2 animal2 = new Animal2();
        animal2.name = "坤坤";
        Animal2 a = (Animal2)animal2.clone();

           System.out.println(animal2.name);
           System.out.println(a.name);
       }

       public static void main4(String[] args) {

           Student1[] student1 = new Student1[3];
           student1[0] = new Student1("法外狂徒张三",23,99);
           student1[1] = new Student1("无敌坤坤",23,1);
           student1[2] = new Student1("小黑子",23,89);

           AgeComparator ageComparator = new AgeComparator();
           ScoreComparator scoreComparator = new ScoreComparator();
           NameComparator nameComparator = new NameComparator();

          // Arrays.sort(student1,ageComparator);//按照年龄比较，从小到大
          // Arrays.sort(student1,nameComparator);//按照姓名比较
           Arrays.sort(student1,scoreComparator);//按照分数比较，从小到大

           System.out.println(Arrays.toString(student1));
       }

       //自主实现sort方法
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

       public static void main3(String[] args) {
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
