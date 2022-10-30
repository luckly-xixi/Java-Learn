public class class3 {
    public static void main(String[] args) {
//        System.out.println((true == true)?(true == true)?false:true:true);
        boolean flg = (true == true)?(true == true)?false:true:true;
        System.out.println(flg);
    }


    public static void main10(String[] args) {
        int a =-1;
        System.out.println(a>>1);
        System.out.println(a<<1);
        System.out.println(a>>>1);
    }

    public static void main9(String[] args) {
        int a = 1;
        System.out.println(!(a == 1));  // a == 1 为true，取个非就是false
        System.out.println(!(a != 1));  // a != 1 为false，取个非就是true


        System.out.println(10 > 20 && 10 / 0 == 0);       // 打印 false
        System.out.println(10 < 20 || 10 / 0 == 0);       // 打印 true
        //10/0  原本是会出现报错的，但是这里却没有，说明&&左边判断过后并没有去判断右边的表达式
        //这就是&&和||的短路运算

//        System.out.println(10 > 20 & 10 / 0 == 0);       // 程序抛出异常
//        System.out.println(10 < 20 | 10 / 0 == 0);       // 程序抛出异常
//            上面的程序会报错，说明无论左边的表达式是否能决定整个表达式都会去
        //再对右边的表达式进行判断
    }


    public static void main8(String[] args) {
        int a = 1;
        int b = a + 2;
        System.out.println(b);
        short x = 5;
        short y =  x+= 2;
        //short y = x + 2; 编译器报错
        //因为2是整形，所以运算时x会被提升为整形，其结果也会是整形的
        System.out.println(y);
    }


    public static void main7(String[] args) {
        int a = 3;
        int b = 2;
// 在数学中应该是1.5 但是在Java中输出结果为1 会向下取整，即小数点之后全部舍弃掉了
        System.out.println(a / b);
// 如果要得到数学中的结果，可以使用如下方式
        double d = a*1.0 / b;
        System.out.println(d);
    }


    public static void main6(String[] args) {
        System.out.println(10%3);//1
        System.out.println(10%-3);//1
        System.out.println(-10%3);//-1
        System.out.println(-10%-3);//-1


        System.out.println(11.5%2);//1.5
    }

    public static void main5(String[] args) {
        System.out.println(5/2);//2
        System.out.println((float) 5/2);//2.5      相当于5.0/2
        System.out.println(5/(float)2);//2.5       相当于5/2.0
        System.out.println((float) (5/2));//2.0        相当于5/2的结果转为float
    }


    public static void main4(String[] args) {
        int num = 10;
// 方法1
        String str1 = num + "++";
// 方法2
        String str2 = String.valueOf(num);

        System.out.println(str1);
        System.out.println(str2);
//        String 转成 int
        String str = "100";
        int x = Integer.parseInt(str);
        System.out.println(x);
    }

    public static void main3(String[] args) {
        int a = 12345;
        String ret = String.valueOf(a);
        System.out.println(ret);
        float f = 12.5f;
        String ret1 = String.valueOf(f);
    }

    public static void main2(String[] args) {
        String s1 ="holle";
        String s2 ="world";
        System.out.println(s1+s2);
        //在字符串当中，如果两个字符串进行相加，意思就是拼接的意思
        int a =10;
        int b = 20;
        System.out.println(a+b);
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        System.out.println("a+b = "+a+b);
        //该表达式会先将字符串“a+b”和+a进行拼接，得到a+b=10，然后“a+b=10”这个整体
        //再与+b拼接得到“a+b=1020”这个答案
        System.out.println("a+b = "+(a+b));
        System.out.println(a+b+"a+b的和是");
        //从左向右计算会先计算a+b的和在与“a+b的和是”进行拼接
    }


    public static void main1(String[] args) {
        String str = "holle";
        System.out.println(str);
        int a =10;
      //  str\a都是局部变量，此时依然存放在栈上
        //在Java中没有所谓的字符串以\0截止
    }
}
