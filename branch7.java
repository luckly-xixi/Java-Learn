import java.util.Date;
import java.util.*;//容易出现冲突，(这个*叫做通配符)作用：随用随取（用到哪个类，就导入哪个类）
import static java.lang.Math.*;//导入了Math类的所有的静态方法，随用随取


class Student {
    private String name;
    public int age;

    //直接赋值
//    public static String classRoom = "306";

    //默认初始化
    public static String classRoom ;
    //在构造对象的时候可以在构造方法中赋值
//    public Student (String name,int age,String a) {
//        this.name = name;
//        this.age = age;
//        classRoom = a;
//    }

    public Student () {
        System.out.println("没有参数的构造方法");
    }

    //实例代码块
    {
        this.name = "giao";
        this.age = 12;
        System.out.println("I am instance init()!");
    }
    //静态方法
    public static void func() {
        System.out.println("name");
    }
//静态代码快
    static {
        System.out.println("静态代码块 -> 初始化静态的数据成员/提前准备一些数据");
    }
    //通过get和set方法来赋值
    public static String getClassRoom() {
        return classRoom;
    }

    public static void setClassRoom(String classRoom) {
        Student.classRoom = classRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void show() {
        System.out.println(name+" "+age);
    }
}

//外部类
class Outclass {

    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;

    //静态内部类
    static class Innerclass {

        public int data4 = 4;
        private int data5 = 5;
        public static int data6 = 6;

        //静态内部类的方法
        public void func() {
            System.out.println("static -> Innerclass : func()");

            Outclass outclass = new Outclass();
            System.out.println(outclass.data1);
            System.out.println(outclass.data2);
//            System.out.println(data1);  //需要通过对象的引用来访问
//            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
        }
    }

//外部类的成员方法
    public void func() {

        Innerclass innerclass = new Innerclass();
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
//        System.out.println(data4);
//        System.out.println(data5);  //访问需要通过对象的引用来访问
//        System.out.println(data6);
        System.out.println(innerclass.data4);
        System.out.println(innerclass.data5);//外部类 可以访问 静态内部类当中的所有成员
        //哪怕是private
        System.out.println(Innerclass.data6);
        //也可以通过调用静态方法的形式来访问
    }

}

class Outclass2 {

    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;

    //非静态内部类
     class Innerclass2 {

        public int data1 = 111;
        public int data4 = 4;
        private int data5 = 5;
//        public static int data6 = 6;
        //非静态内部类里面不能定义静态的变量，如果要定义
        //需需要通过final关键字来修饰

        //常量是在程序编译的时候  就能确定的
        public static final int data7 = 6;

        //非静态内部类的方法
        public void func() {

            System.out.println(data1);
            System.out.println("加this"+this.data1);
            System.out.println("加外部类引用"+Outclass2.this.data1);

            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data7);

        }
    }

    //外部类方法
    public void func() {

         Innerclass2 innerclass2 = new Innerclass2();
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
//        System.out.println(data4);
//        System.out.println(data5);
//        System.out.println(data7);
        System.out.println(innerclass2.data4);
        System.out.println(innerclass2.data5);
        System.out.println(innerclass2.data7);

    }

}


class Outerclass {

    public void func() {
    //局部内部类
        class Innerclass{
            // 局部内部类：定义在方法体内部
            // 不能被public、static等访问限定符修饰
            public int a =1;

            public void fun() {
                System.out.println(a);
            }
        }
        // 只能在该方法体内部使用，其他位置都不能用
        Innerclass innerclass = new Innerclass();
        innerclass.fun();
    }

}

//匿名内部类
interface IA {
    public void fun() ;
}

class AA implements IA{

    public void fun() {
        System.out.println("哭你吉瓦");
    }
}
public class branch7 {

    public static void main(String[] args) {
        //有一个没有名字的类实现了IA接口
        //同时实现了fun的方法
        new IA() {
            //相当于是上面的实现接口的AA类
            public void fun() {
                System.out.println("????");
            }
        }.fun();
        //调用匿名内部类的是实现方法
    }

    public static void main12(String[] args) {
    IA ia = new AA();
    ia.fun();
    }

    public static void main11(String[] args) {
    Outerclass outerclass = new Outerclass();
    outerclass.func();
        // OutClass.InnerClass innerClass = null; 编译失败
    }

    //实例内部类
    public static void main10(String[] args) {
//        Innerclass2 innerclass2 = new Innerclass2();
        //要实例化一个非静态内部类的对象，需要先实例化一个外部类的对象
        //然后通过外部类.来调用并且实例化非静态内部类的对象
        Outclass2 outclass2 = new Outclass2();
        Outclass2.Innerclass2 innerclass2 = outclass2.new Innerclass2();
        innerclass2.func();
    }

    public static void main9(String[] args) {
        //实例化一个内部类的对象
        //需需要通过  外部类.内部类  来实现
        Outclass.Innerclass innerclass = new Outclass.Innerclass();
        innerclass.func();
    }


    public static void main8(String[] args) {
        Student student = new Student();
        student.show();
    }

    public static void main7(String[] args) {
        Student.func();
    }

    public static void main6(String[] args) {
        Student student = new Student();
    }

    public static void main5(String[] args) {
        { //直接使用{}定义，普通方法块
            int x = 10 ;
            System.out.println("x1 = " +x);
        }
        int x = 100 ;
        System.out.println("x2 = " +x);
    }


    public static void main4(String[] args) {

        {
            int a =1;
        }
//        System.out.println(a);
    }

    public static void main3(String[] args) {
        Student student = new Student();
        student.show();

        Student.func();
        System.out.println(Student.classRoom);
    }

    public static void main2(String[] args) {
        Student student = new Student();

        System.out.println(Student.classRoom);
    }

    public static void main1(String[] args) {
        Student student = new Student();
//        student.name = "giao";

        java.util.Date date = new java.util.Date();//太冗余了

        int[] array = {1,2,3,4};
        Arrays.sort(array);

        double x = 10;
        double y = 20;
//        double result = Math.pow(x,2) + Math.pow(y,2);
        double result = sqrt(pow(x,2) + pow(y,2));
    }
}
