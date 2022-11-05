import java.util.Scanner;

public class work1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        int a = input.nextInt();
//
//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < a; j++) {
//                if(i == j ||i+j == a-1) {
//                    System.out.print("*");
//                }else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }

        while (input.hasNextInt()) {
            int a = input.nextInt();

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    if(i == j ||i+j == a-1) {
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

    }

        // 获取一个数的二进制序列中的所有偶数位和奇数位，分别输出二进制序列
    public static void main9(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        for (int i = 31; i >= 1; i-=2) {
            System.out.println("偶数"+((a >>> 1) & 1));
        }
        for (int i = 30; i >= 0; i-=2) {
            System.out.println("奇数"+((a >>> 1) & 1));
        }

    }

    public static double num (int x) {
        if(x < 10) {
            return x;
        }
        return (Math.pow(x % 10,3))+num(x / 10);
    }

    public static void main8(String[] args) {
        //求0 ~ 999 之间的水仙花数
//        for (int i = 0; i <= 999; i++) {
//           if(i >= 100) {
//               double b = num(i);
//               if(b == i) {
//                   System.out.println(b);
//               }
//           }
//        }

        for (int i = 0; i <= 1000; i++) {
            //判断i是几位数，求得每个位上是几
            //加起来 == 原来的数字
            int count = 0;
            int tmp = i;
            while(tmp != 0) {
                count++;
                tmp = tmp/10;
            }
            tmp = i;
            int sum = 0;
            while (tmp != 0){
                sum += Math.pow(tmp%10,count);
                tmp /= 10;
            }
            if(sum == i) {
                System.out.println(i);
            }
        }
    }

    public static void main7(String[] args) {
        //9*9乘法表
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+"*"+j+"="+i*j+"  ");
            }
            System.out.println();
        }
    }

    public static void main6(String[] args) {
        //求2个整数的最大公约数
        //方法一：
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
//        if (a > b) {
//            for (int i = a; i > 0; i--) {
//                if ((a % i == 0) && (b % i == 0)) {
//                    System.out.println("最大公约数是" + i);
//                    break;
//                }
//            }
//        } else if (b > a) {
//            for (int i = b; i > 0; i--) {
//                if ((a % i == 0) && (b % i == 0)) {
//                    System.out.println("最大公约数是" + i);
//                    break;
//                }
//            }
//        }


        //方法二：辗转相除法
        int c = a % b;
        while(c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        System.out.println(b);
    }

    public static void main5(String[] args) {
        //求一个整数，在内存当中存储时，二进制1的个数。
        int count = 0;
        int a = -1;
//        while (a != 0) {
//            if ((a & 1) != 0) {
//                count++;
//            }
//            a = a >>> 1;
//        }
//        System.out.println(count);

        while (a != 0) {
            a = a & (a -1);
            count++;
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
            if (a % i == 0) {
                break;
            }
        }
        if (a == i) {
            System.out.println(i + "是素数");
        }
    }

    public static void main3(String[] args) {
        //输出 1000 - 2000 之间所有的闰年
        int count = 0;
        for (int i = 1000; i <= 2000; i++) {
            if ((i % 400 == 0) || (i % 4 == 0 && i % 100 != 0)) {
                count++;
                System.out.println(i);
            }
        }
        System.out.println("个数为" + count);
    }

    public static void main2(String[] args) {
        //编写程序数一下 1到 100 的所有整数中出现多少个数字9
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i / 10 != 9) {
                if (i % 10 == 9) {
                    count++;
                    System.out.println(i);
                }
            }
            if (i / 10 == 9) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("个数为" + (count + 1));
    }

    public static void main1(String[] args) {
        //打印 1 - 100 之间所有的素数
//        for (int i = 2; i <= 100; i++) {
//            for (int j = 1; j <= i; j++) {
//                if (i % j == 0) {
//                    if (j == 1) {
//                        continue;
//                    } else {
//                     if(i == j) {
//                         System.out.println(i);
//                         break;
//                     }else {
//                         break;
//                     }
//                    }
//                }
//            }
//        }
//    }
        //方法二：
//        for (int i = 2; i <= 100; i++) {
//            int j = 2;
//            for (; j < i; j++) {
//                if (i % j == 0) {
//                    break;
//                }
//            }
//            if (i == j) {
//                System.out.println(i);
//            }
//        }
//    }

    //方法三：
//        for (int i = 2; i <= 100; i++) {
//            int j = 2;
//            for (; j <= i/2; j++) {
//                if (i % j == 0) {
//                    break;
//                }
//            }
//            if (i/2 < j) {
//                System.out.println(i);
//            }

            //方法四：
        for (int i = 2; i <= 100; i++) {
            int j = 2;
            for (; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (i > Math.sqrt(i)) {
                System.out.println(i);
            }
        }
    }


    }
