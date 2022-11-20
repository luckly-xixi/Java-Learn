
class Animals {

   public String name;
   public int age;

    public void eat() {

        System.out.println(name+"正在吃饭！");
    }
}

class Dogs extends Animals {

    public void Call() {
        System.out.println(name+"正在拆家！");
    }
    @Override
    public void eat () {
        System.out.println(name+"正在吃狗粮！");
    }
}

class Cats extends Animals {

    public void Run() {
        System.out.println(name+"正在奔跑！");
    }

    @Override
    public void eat() {
        System.out.println(name+"正在吃猫粮！");
    }
}

class Shape {
    //属性....
    public void draw() {
        System.out.println("画图形！");
    }
}
class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("♦");
    }
}
class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("●");
    }
}
class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class B {
    public B() {
        // do nothing
        func();
    }
    public void func() {
        System.out.println("B.func()");
    }
}
class D extends B {
    private int num = 1;
    @Override
    public void func() {
        System.out.println("D.func() " + num);
    }
}

public class branth8 {

    public static void main(String[] args) {
        D d = new D();
    }

    //圈复杂度（不基于多态）
    public static void drawShapes() {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();
        String[] shapes = {"cycle", "rect", "cycle", "rect", "flower"};

        for (String shape : shapes) {
            if (shape.equals("cycle")) {
                cycle.draw();
            } else if (shape.equals("rect")) {
                rect.draw();
            } else if (shape.equals("flower")) {
                flower.draw();
            }
        }
    }

    //圈复杂度（多态）

    static void drawShapes2() {
        Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();

        Shape[] shapes ={rect,cycle,rect,cycle,flower};

        for (Shape shape:shapes) {
            shape.draw();
        }
    }

    public static void main6(String[] args) {
//        drawShapes();
        drawShapes2();
    }

    //向下转型
    public static void main5(String[] args) {
        Animals animals = new Dogs();

        Dogs dogs = (Dogs) animals;
        dogs.Call();

        System.out.println("==============");

       if (animals instanceof Cats) {
           Cats cats = (Cats) animals;
           cats.Run();
       }
    }


    //向上转型三：方法的返回值
    public static Animals func2() {
        return new Dogs();
    }

    public static void function(Animals animals) {
        animals.eat();
    }

    public static void main4(String[] args) {

        Animals animals1 = new Dogs();
        animals1.name = "菜狗";
//        animals1.eat();
        function(animals1);
        System.out.println("==============");

        Animals animals2 = new Cats();
        animals2.name= "八嘎猫";
//        animals2.eat();
        function(animals2);
    }

    public static void func(Animals animals1 ) {
    }

    //向上转型二：方法的传参
    public static void main3(String[] args) {

        Dogs dogs = new Dogs();
        func(dogs);
    }

        //初步进入多态,向上转型一:直接赋值
    public static void main2(String[] args) {
        Animals animals1 = new Dogs();
        animals1.name = "菜狗";
        animals1.eat();
//        animals1.Call():

        System.out.println("==============");

        Animals animals2 = new Cats();
        animals2.name= "八嘎猫";
        animals2.eat();
    }

    public static void main1(String[] args) {

        Dogs dogs = new Dogs();
        dogs.name = "菜狗";
        dogs.eat();
        dogs.Call();

        Animals animals = dogs;
        System.out.println("==============");

        Cats cats = new Cats();
        cats.name = "八嘎猫";
        cats.eat();
        cats.Run();
    }

}
