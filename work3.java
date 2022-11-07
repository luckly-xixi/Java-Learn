import java.util.Arrays;
import java.util.Scanner;

public class work3 {

    public static void main(String[] args) {
        //实现一个方法 printArray, 以数组为参数,
        // 循环访问数组中的每个元素, 打印每个元素的值.
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] array = new int[n];
        printArray(array);
    }
    public static void printArray(int []array) {
        for (int x :array
             ) {
            System.out.println(x);
        }

    }

    public static void main7(String[] args) {
        //创建一个 int 类型的数组, 元素个数为 100,
        // 并把每个元素依次设置为 1 - 100
        int [] array = new int[100];
//        for (int i = 0; i < 100; i++) {
//            array[i] = i+1;
//        }
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
//        for (int i = 0; i < 100; i++) {
//            System.out.println("array["+i+"]为"+array[i]+"  ");
//        }
        System.out.println(Arrays.toString(array));
    }

    public static void main6(String[] args) {
        hannuota(1,'a','b','c');
        System.out.println();
        hannuota(2,'a','b','c');
        System.out.println();
        hannuota(3,'a','b','c');
    }
    public static void hannuota(int n,char pos1,char pos2,char pos3) {
        if(n == 1) {
            move(pos1,pos3);
            return;
        }
        hannuota(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hannuota(n-1,pos2,pos1,pos3);
    }
    public static void move(char pos1,char pos2) {
        System.out.print(pos1+"—》"+pos2+"    ");
    }
    public static void main5(String[] args) {
        //递归求斐波那契数列的第 N 项
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        int b = fab(a);
        System.out.println("斐波那契数列的第"+a+"项为"+b);
    }
public static int fab(int x) {
        if(x == 1||x == 2) {
            return 1;
        }
        return fab(x -1)+fab(x - 2);
}
    public static void main4(String[] args) {
        //写一个递归方法，输入一个非负整数，返回组成它的数字之和
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        int b = inc(a);
        System.out.println(b);

        int c =add(a);
        System.out.println(c);
    }
    public static int inc(int x) {
        int sum =0;
        if(x < 10) {
            return x;
        }
        sum = (x%10)+inc(x / 10);
        return sum;
    }
    public static int add(int n) {
        if(n > 10) {
            return add(n/10)+n%10;
        }
        return n%10;
    }
    public static void main3(String[] args) {
        //按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
        int a = 1234;

        print(a);
    }
    public static void print(int x) {
        if(x < 10) {
            System.out.println(x);
            return ;
        }
        print(x / 10);
        System.out.println(x % 10);
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
