import com.sun.javafx.image.impl.IntArgb;

public class TestDemo {
    public static void main11(String[] args) {
        int a = 10;
        long b = 100L;
        b = a;     // int-->long，数据范围由小到大，隐式转换
        a = (int)b;  // long-->int, 数据范围由大到小，需要强转，否则编译失败
        float f = 3.14F;
        double d = 5.12;
        d = f;     // float-->double，数据范围由小到大，隐式转换
        f = (float)d; // double-->float, 数据范围由大到小，需要强转，否则编译失败
//        a = d;  // 报错，类型不兼容
        a = (int)d;  // int没有double表示的数据范围大，需要强转，小数点之后全部丢弃
        byte b1 = 100;     // 100默认为int，没有超过byte范围，隐式转换
        byte b2 = (byte)257;  // 257默认为int，超过byte范围，需要显示转换，否则报错
        boolean flag = true;
//        a = flag;  // 编译失败：类型不兼容
//        flag = a;  // 编译失败：类型不兼容
    }

    public static void main10(String[] args) {
        byte a = 10;
        byte b = 20;
//        byte c = a + b;小于四个字节的，在运算的时候会自动提升为4个字节
//        System.out.println(c);
    }


    public static void main9(String[] args) {
        boolean flg = true;
//        boolean flg = 1;会报错，1被认为是整形的哪怕是强制类型转化也不行
//        只能赋值为true或者false，没有明确大小
        System.out.println(flg);
    }

    public static void main8(String[] args) {
        char ch = 'a';//2个字节  不能是复数
        System.out.println(ch);
        char ch2 = '好';
        //一个汉字是两个字节
        System.out.println(ch2);
        char c2 = 97;   // 数字字符
        //存储的是数字的话，输出的是数字对应的字符
        System.out.println(c2);
    }

    public static void main7(String[] args) {
           float f = 12.5f;//浮点型默认为double的，所以在数字后面加一个f或者强制转换一下
        //才能存放到float里面
        System.out.println(f);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
    }

    public static void main6(String[] args) {
        double d = 12.5;//小数默认就是double的，占8个字节
        System.out.println(d);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
    }


    public static void main5(String[] args) {
        byte c = 10;//1个字节   取值范围-128 ~ 127
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
    }

    public static void main4(String[] args) {
        short b = 10;//2个字节   取值范围-32768 ~ 32767
        System.out.println(b);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
    }

    public static void main3(String[] args) {
        long a = 10L;//为了区分int和long类型，一般建议：long类型变量的初始值之后加L或者l
        //8个字节    取值范围-2^63 ~ 2^63
        System.out.println(a);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
    }



    public static void main2(String[] args) {
        //数据类型   变量名  =  赋值   变量：可以在运行过程中改变的量
        int a = 10;//a是整形变量，占四个字节 32位
        //在java当中没有所谓的无符号有符号的概念
        a = 20 ;
        //4个字节   取值范围是-2^31 ~ 2^31
        System.out.println(a);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }


    public static void main1(String[] args) {
//        System.out.println("hello！");
//        System.out.println(100);
//        for(int i=0;i<args.length;i++){
//            System.out.println(args[i]);
//        }
    }
}
