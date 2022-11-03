import java.util.Scanner;

public class work1 {

    public static void main6(String[] args) {
        //求2个整数的最大公约数
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        if (a > b) {
            for (int i = a; i > 0; i--) {
                if ((a % i == 0) && (b % i == 0)) {
                    System.out.println("最大公约数是" + i);
                    break;
                }
            }
        } else if (b > a) {
            for (int i = b; i > 0; i--) {
                if ((a % i == 0) && (b % i == 0)) {
                    System.out.println("最大公约数是" + i);
                    break;
                }
            }
        }
    }

    public static void main5(String[] args) {
        //求一个整数，在内存当中存储时，二进制1的个数。
        int count = 0;
        int a = 5;
        while(a != 0) {
            if((a & 1) != 0){
                count++;
            }
            a = a >> 1;
        }
        System.out.println(count);
    }


    public static void main4(String[] args) {
        //给定一个数字，判定一个数字是否是素数
        int count = 0;
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int i = 1;
        for (i = 2; i < a; i++) {
            if(a % i == 0) {
                break;
            }
        }if (a == i) {
            System.out.println(i+"是素数");
        }
    }

    public static void main3(String[] args) {
        //输出 1000 - 2000 之间所有的闰年
        int count =0 ;
        for (int i = 1000; i <= 2000; i++) {
            if((i % 400 == 0)||(i % 4 == 0 && i % 100 != 0)) {
                count++;
                System.out.println(i);
            }
        }
        System.out.println("个数为"+count);
    }

    public static void main2(String[] args) {
        //编写程序数一下 1到 100 的所有整数中出现多少个数字9
        int count = 0 ;
        for (int i = 1; i <= 100 ; i++) {
           if(i / 10 != 9) {
               if(i % 10 == 9) {
                   count++;
                   System.out.println(i);
               }
           } if(i / 10 == 9) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("个数为"+(count+1));
    }

    public static void main1(String[] args) {
        //打印 1 - 100 之间所有的素数
        for (int i = 2; i <= 100; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    if (j == 1) {
                        continue;
                    } else {
                     if(i == j) {
                         System.out.println(i);
                         break;
                     }else {
                         break;
                     }
                    }
                }
            }
        }
    }

}