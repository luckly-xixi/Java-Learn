

    class Person {
        public String name;
        public int age;

        public void eat() {
            System.out.println("吃饭！");
        }
        public void sleep() {
            System.out.println("睡觉！");
        }
    }

    class WashMachine {
        public String brand;  // 品牌
        public String type;   // 型号
        public double weight;  // 重量
        public double length;  // 长
        public double width;  // 宽
        public double height;  // 高
        public String color;  // 颜色

        public void washClothes(){  // 洗衣服
            System.out.println("洗衣功能");
        }

        public void dryClothes(){   // 脱水
            System.out.println("脱水功能");
        }

        public void setTime(){    // 定时
            System.out.println("定时功能");
        }
    }

    class Phone {
        public String brand;  // 品牌
        public String type;   // 型号
        public double weight;  // 重量
        public double length;  // 长
        public double width;  // 宽
        public double height;  // 高
        public String color;  // 颜色
        public String screen;

        public void movie() {
            System.out.println(screen+"看电影！");
        }
        public void call() {
            System.out.println("打电话！");
        }
    }
    class PetDog {
        public String name;//名字
        public String color;//颜色
        // 狗的属性
        public void barks() {
            System.out.println(name + ": 旺旺旺~~~");
        }

        // 狗的行为
        public void wag() {
            System.out.println(name + ": 摇尾巴~~~");
        }
    }
    public class class7 {

        public static void main(String[] args) {
            Phone phone = new Phone();
            phone.brand = "三星";
            phone.movie();
            phone.length = 5;

            String s = null;
            System.out.println(s);
            System.out.println(s.length());

        }

    public static void main1(String[] args) {

        //通过关键字new实例化了一个对象
        Phone phone = new Phone();
        Person a = new Person();
        WashMachine b = new WashMachine();
    }
}
