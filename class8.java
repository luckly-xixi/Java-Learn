

// Dog.java

/* class Dog{
            String name;
        int age;
        float weight;

        public void eat(){
            System.out.println(name + "正在吃饭");
        }

        public void sleep(){
            System.out.println(name + "正在睡觉");
        }

        void Bark(){
            System.out.println(name + "汪汪汪~~~");
        }
    }*/




    // Cat.Java

/*class Cat{
            String name;
        int age;
        float weight;

        public void eat(){
            System.out.println(name + "正在吃饭");
        }

        public void sleep()
        {
            System.out.println(name + "正在睡觉");
        }

        void mew(){
            System.out.println(name + "喵喵喵~~~");
        }
    }*/

     class Animal{
    String name;
    int age;

    public void eat(){
        System.out.println(name + "正在吃饭");
    }

    public void sleep(){
        System.out.println(name + "正在睡觉");
    }
}

// Dog.java
    class Dog extends Animal{
    void bark(){
        System.out.println(name + "汪汪汪~~~");
    }
}
// Cat.Java
    class Cat extends Animal{
    void mew(){
        System.out.println(name + "喵喵喵~~~");
    }
}

    class Beas {
         public int a;
         public int b;
         int c = 9;
         public void methodA() {
             System.out.println("Base中的方法");
         }
    }
class Derive extends Beas {
    //子类和父类成员和方法同名字
    public int c = 6;
    public void func(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);//优先使用子类自己的成员
        System.out.println(super.c);//访问父类的c成员
        methodB();
        super.methodA();
//        System.out.println(d);//编译器报错，无法编译，因为d在
        //子类和父类中都没有
        //子类有就使用子类的，子类没有就使用父类的
    }
    public void methodA() {
        System.out.println("Derive当中的方法");
    }
    public void methodB() {
        System.out.println("Derive");
    }
}
class Derived extends Beas {
    //子类和父类成员不同名字
    public int d;
    public void func(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
        //子类有就使用子类的，子类没有就使用父类的
    }
}
class Father {
        public int a = 6 ;
        public float b;
        public String c;
    public Father(int a,  String c) {
        this.a = a;
        this.c = c;
        System.out.println("Father带两个参数的构造方法");
    }
    public Father() {
        System.out.println("Father()");
    }
    static {
        System.out.println("Father static{}");
    }
    {
        System.out.println("Father {}");
    }
    public void methodA() {
        System.out.println("Father当中的方法A");
    }
    public void methodB() {
        System.out.println("Father当中的方法B");
    }
}
class Son extends Father {
         public char d;
         public int a = 5 ;
        public Son (){
        //里面虽然什么都没加，但是编译器默认认为调用父类的无参数构造方法
            //super（）{} 编译器默认帮你加上
            System.out.println("Son()");
        }
    public void methodA() {
        System.out.println("Son当中的方法A");
    }
    static {
        System.out.println("Son static {}");
    }
    {
        System.out.println("Son {}");
    }
}
class School {
         public Studentens[] studentens;
         public Teacher[] teachers;
}
class Studentens {
        String name[];
}
class Teacher {
        String name[];
}

class My_value {
//    public int val;
    private int val;
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

    public class class8 {

         public static void swp(My_value val1, My_value val2) {

//            int tmp = val1.val;
             int tmp = val1.getVal();
//            val1.val = val2.val;
             val1.setVal(val2.getVal());
//            val2.val = tmp;
             val2.setVal(tmp);
         }

         //交换（通过对对象的调用）
        public static void main11(String[] args) {
             My_value my_value1 = new My_value();
//             my_value1.val = 10;
             my_value1.setVal(10);

            My_value my_value2 = new My_value();
//            my_value2.val = 20;
            my_value2.setVal(20);

            swp(my_value1,my_value2);
//            System.out.println(my_value1.val);
//            System.out.println(my_value2.val);
            System.out.println(my_value1.getVal());
            System.out.println(my_value2.getVal());

        }

         //组合
         public static void main10(String[] args) {
            School school = new School();
         }


        public static void main9(String[] args) {
            final int[] array = {1,2,3};
//            array = new int[10];
            array[0] = 555 ;
        }
        //final 关键字
        public static void main8(String[] args) {
            int a = 9 ;
            a = 100 ;
            final int B = 4 ;
//            b = 5 ;
        }

        public static void main7(String[] args) {
            Father father1 = new Father();
            System.out.println("=======");
            Father father2 = new Father();
        }

        public static void main6(String[] args) {
            Son son1 = new Son();
            System.out.println("======");
            Son son2 = new Son();
            System.out.println("--------");
            Father father1 = new Father();
            System.out.println("=======");
            Father father2 = new Father();
        }

        public static void main5(String[] args) {
            Father father =new Father(10,"giao");
            Son son = new Son();
        }
         //父类和子类当中的方法同名
         public static void main4(String[] args) {
             Derive derive = new Derive();
             derive.methodA();
             derive.func();
         }
         //父类成员访问
        public static void main3(String[] args) {
        Derive derive = new Derive();
        derive.func();
        //如果父类和子类有同名的成员变量，优先访问自己的
        }
        public static void main2(String[] args) {
            Derived derived = new Derived();
            derived.func();
        }
        //继承语法的认识
        public static void main1(String[] args) {
            Dog dog = new Dog();
            dog.name = "菜狗";
            dog.bark();
            dog.eat();
            Cat cat = new Cat();
            cat.name = "八嘎猫";
            cat.mew();
            cat.eat();
        }
}
