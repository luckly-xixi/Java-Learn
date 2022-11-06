import java.util.Scanner;

public class work3 {

    public static void main(String[] args) {
        //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
        int a = 1234;

        System.out.println(print(a));
    }
    public static int print(int x) {
        if(x < 10) {
            return x;
        }
        return print(x / 10);
    }

    public static void main2(String[] args) {
        //递归求 1 + 2 + 3 + ... + 10
        int a = 10;
        int b = sum(a);
        System.out.println("1 - 10 的和为"+b);
    }
    public static int sum(int x) {
        if(x == 1) {
            return 1;
        }
        return x + sum(x-1);
    }

    public static void main1(String[] args) {
        //递归求 N 的阶乘
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        int b = rec(a);
        System.out.println(a+"的阶乘值为"+b);
    }
    public static int rec(int x) {
        if(x == 1) {
            return 1;
        }
        return x*rec(x-1);
    }
}
