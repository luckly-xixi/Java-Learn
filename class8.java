

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
    public class class8 {
         //父类和子类当中的方法同名
         public static void main(String[] args) {
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
