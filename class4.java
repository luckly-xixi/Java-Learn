import java.io.StringReader;
import java.util.Scanner;

public class class4 {

    public static void main(String[] args) {

        //固定格式
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String name = input.next();
        //相对于nextInt啥的next输入的时候遇见空格就会结束

        System.out.println(n);
        //用完记得关闭
        input.close();
    }

    public static void main19(String[] args) {
        //for循环的死循环

        for (int i = 0; ; i++) {
            System.out.println(i);
        }
    }

    public static void main18(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void main17(String[] args) {
            //找1-100内，既能被3也可以被5整除的数字，
        //要求：使用break或者continue当中的的一个
        int i =1;
        while(i <= 100) {
            if(i % 15 == 0) {
                System.out.println(i);
                i++;
                continue;
            }
            i++;
        }
    }

    public static void main16(String[] args) {
        //while的死循环
        while(true) {
            //括号里只能是布尔表达式
            System.out.println("a");
        }
    }

    public static void main15(String[] args) {
        //计算5的阶乘的和
        int i = 1;
        int ret = 0;
        while (i <= 5) {
            int n =1;
            int sum = 1;
            while (n <= i) {
                sum *= n;
                n++;
            }
            ret += sum;
            i++;
        }
        System.out.println(ret);
    }


    public static void main14(String[] args) {
        //1-100的和
        int i = 1;
        int sum = 0;
        while(i <= 100) {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }


    public static void main13(String[] args) {
        int a = 1;
        while(a <= 3) {
            //while的判断条件必须是布尔表达式
            System.out.println(a);
            a++;
        }
        System.out.println("aaaa");
    }

    public static void main12(String[] args) {
        //不能做Switch的参数的数据类型是：
        //long\float\double\boolean
        //double num = 1.0;
        //switch(num) {


//        if (num > 10 && num < 20) {
//            System.out.println("hehe");


//            case 1.0:
//                System.out.println("hehe");
//                break;
//            case 2.0:
//                System.out.println("haha");
//                break;
//        }

    }

    public static void main11(String[] args) {
        int a = 10;
        switch (a) {
            case 1 :
                System.out.println("1");
                break;
            case 2 :
                System.out.println("2");
                break;
            default:
                System.out.println("输入有误！");
                break;
        }
    }

    public static void main10(String[] args) {

        int x = 10;
        int y = 10;
        if (x == 10)
            if (y == 10)
                System.out.println("aaa");
            else
                System.out.println("bbb");
    }

    public static void main8(String[] args) {
        //判断一个年份是否是闰年
        int year = 2022;
//        if((year % 100 == 0) && (year % 400 == 0) ) {
//            System.out.println(year + "是闰年");
//        }else if((year % 4 == 0)&&(year % 100 != 0)) {
//            System.out.println(year + "是闰年");
//        }else {
//            System.out.println("不是闰年！");
//        }
        if(year % 100 == 0)
        {
            if(year % 400 == 0)
            {
                System.out.println(year + "是闰年");
            }
            else
            {
                System.out.println(year + "不是闰年");
            }
        }
        else
        {
                if(year % 4 == 0)
                {
                    System.out.println(year + "是闰年");
                }
                else
                {
                    System.out.println(year + "不是闰年");
                }

        }
    }

    public static void main7(String[] args) {
        //判断一个数是正数负数还是零
        int num = 9;
        if(num > 0 ) {
            System.out.println("正数");
        }else if(num < 0){
            System.out.println("负数");
        }else {
            System.out.println("0");
        }
    }

    public static void main6(String[] args) {
        //判断一个数字是奇数还是偶数
        int num = 10;
        if(num % 2 == 0){
            System.out.println(num + "是偶数！");
        }else {
            System.out.println(num + "是奇数！");
        }
    }


    public static void main5(String[] args) {
        //语法格式3
        int a = 9;
        if(a == 9) {
            System.out.println("Yes!");
        }else if(a > 9){
            System.out.println("No!");
        }else {
            System.out.println("haha!");
        }

    }


    public static void main4(String[] args) {
        //语法格式2
        int a = 9;
        if(a == 10) {
            System.out.println("Yes!");
        }else {
            System.out.println("No!");
        }
    }


    public static void main3(String[] args) {
        //选择结构  语法格式1
        int a = 10;
        if(a == 10) {
            System.out.println("Yes!");
        }
    }

    public static void main2(String[] args) {
        //顺序结构
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("5");
        System.out.println("4");
    }

    //既能被3整除，也能被5整除，要求使用continue或者break
    public static void main1(String[] args) {
        int i = 1;
          while(i <= 100) {
              if(i % 3 == 0 && i % 5 == 0) {
                  System.out.println(i);
                  i++;
              }
              i++;
          }
    }
}
