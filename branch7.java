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




public class branch7 {

    public static void main(String[] args) {
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
