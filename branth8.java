
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
public class branth8 {

    //向上转型三：方法的返回值
    public static Animals func2() {
        return new Dogs();
    }

    public static void main(String[] args) {

        Animals animals1 = new Dogs();
        animals1.name = "菜狗";
        animals1.eat();

        System.out.println("==============");

        Animals animals2 = new Cats();
        animals2.name= "八嘎猫";
        animals2.eat();
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
