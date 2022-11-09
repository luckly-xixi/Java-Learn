

    class Person {
        public String name;
        public int age;

        public void eat() {
            System.out.println("吃饭！");
        }
        public void sleep() {
            System.out.println("睡觉！");
        }

        public void show() {
            System.out.println(name+age);
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

    class Date {
        public int year;
        public int month;
        public int day;

        public void setDay(Date this,int y, int m, int d) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        /*public Date() {
            this.year = 1900;
            this.month = 1;
            this.day = 1;
        }*/
        public Date() {
           this(1999,9,9);
            System.out.println("不带参数的构造方法");
        }
        public Date(int year,int month,int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public void printDate() {
            System.out.println(year + "/" + month + "/" + day);
        }
    }
        public class class7 {

            public static void main(String[] args) {
                Date date1 = new Date();
                date1.printDate();
            }

            public static void main7(String[] args) {
                Date date1 = new Date(2022,11,9);
                date1.printDate();
            }

            public static void main6(String[] args) {
                Date date1 = new Date();
                date1.setDay(2022,11,9);
                date1.printDate();

                Date date2 = new Date();
                date1.setDay(2022,11,10);
                date1.printDate();

                Date date3 = new Date();
                date1.setDay(2022,11,11);
                date1.printDate();
            }

            public static void main5(String[] args) {
                Person person = new Person();
                person = new Person();
                person = new Person();
                person = new Person();
                person = new Person();
                person = new Person();
                person = new Person();

            }

            public static void main4(String[] args) {
                Person person1 = new Person();
                Person person2 = new Person();

                person1 = person2;
            }

            public static void main3(String[] args) {
                //此时person1不指向任何对象
                Person person1 = null;
                person1.age = 10;
                person1.name = "张三";
                person1.show();
            }

            public static void main2(String[] args) {
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

