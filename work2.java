import java.util.Scanner;

public class work2 {

    public static void main8(String[] args) {
        //在同一个类中定义多个方法：
        // 要求不仅可以求2个整数的最大值，还可以求3个小数的最大值？
        int a = 2;
        int b = 3;
        double c = 2.1;
        double d = 3.1;
        double e = 4.1;
        System.out.println(max2(a,b));
        System.out.println(max2(c,d,e));
    }
    public static double max2(double x,double y,double z) {
        x = max2(x,y);
        x = max2(x,z);
        return x;
    }
    public static double max2(double x,double y) {
        return x>y?x:y;
    }

    public static void main7(String[] args) {
        //在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。
        // 并执行代码，求出结果
        int a = 2;
        int b = 2;
        double c = 2.1;
        double d = 2.1;
        double e = 2.1;
        System.out.println(sum(a,b));
        System.out.println(sum(c,d,e));
    }

    public static int sum(int x,int y) {
        return x+y;
    }
    public static double sum(double x,double y,double z) {
        return x+y+z;
    }

    public static int fab(int x){
        if(x == 1||x == 2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for (int i = 3; i <= x; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    public static void main6(String[] args) {
        //求斐波那契数列的第n项。(迭代实现)

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        int b = fab(a);
        int c = fab1(a);
        System.out.println("斐波那契的第"+a+"项值为"+b);
        System.out.println("斐波那契的第"+a+"项值为"+c);
    }
    public static int fab1(int x) {
        if(x == 1||x == 2) {
            return 1;
        }
        return fab1(x-1)+fab1(x-2);
    }

    public static void main5(String[] args) {
        //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
        //
        //要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = max2(a,b);
        System.out.println(d);
        int e = max3(a,b,c);
        System.out.println(e);
    }
    public static int max2(int x,int y) {
        return x>y?x:y;
    }
    public static int max3(int x,int y,int z) {
                 x = max2(x,y);
                 x = max2(x,z);
        return x;
    }

    public static void main4(String[] args) {
        //输出n*n的乘法口诀表，n由用户输入。
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+"*"+j+"="+i*j+"   ");
            }
            System.out.println();
        }
    }

    public static void main3(String[] args) {
        //编写代码模拟三次密码输入的场景。
        // 最多能输入三次密码，密码正确，
        // 提示“登录成功”,密码错误，
        // 可以重新输 入，最多输入三次。三次均错，则提示退出程序
        int count = 0;
        Scanner input = new Scanner(System.in);

//        while (count != 3) {
//            int a = input.nextInt();
//            if(a == 3) {
//                System.out.println("登陆成功！");
//            }
//            count++;
//            System.out.println("密码错误！");
//        }
//        System.out.println("退出程序！");

        String passWorld = input.nextLine();
        while (count != 3) {
            System.out.println("请输入你的密码");
            if(passWorld.equals("123456")) {
                System.out.println("登陆成功！");
                break;
            } else {
                System.out.println("你还有"+count+"次机会");
                count++;
            }
        }
        System.out.println("退出程序！");
    }

    public static void main2(String[] args) {
        //输出一个整数的每一位，如：123的每一位是3，2，1
        int a = 123;
        while (a != 0) {
            System.out.println(a%10);
            a /= 10;
        }
    }

    public static void main1(String[] args) {
        //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值 。
        double tmp1 = 0;
        for (int i = 1; i <= 100; i+=2) {
            tmp1 += 1.0/i;
        }
        double tmp2 = 0;
        for (int i = 2; i <= 100; i+=2) {
            tmp2 += 1.0/i;
        }
        System.out.println(tmp1-tmp2);
    }

    public static void main9(String[] args) {
        double sum = 0;
        int flg = 1;
        for (int i = 1; i <= 100; i++) {
            sum += 1.0 / i * flg;
            flg = - flg;
        }
        System.out.println(sum);
    }
}
