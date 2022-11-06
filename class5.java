import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class class5 {



    public static int getSum(int N){   // N是形参
        return (1+N)*N / 2;
    }

    public static void main3(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += fac(i);
        }
        System.out.println("sum = " + sum);
        getSum(10);    // 10是实参,在方法调用时，形参N用来保存10
        getSum(100);   // 100是实参，在方法调用时，形参N用来保存100
    }

    public static int fac(int n) {
        //计算 1! + 2! + 3! + 4! + 5!
        System.out.println("计算 n 的阶乘中n! = " + n);
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int fa(int n) {
        int ret =1 ;
        for (int j = 1; j <= n; j++) {
            ret *= j;
        }
        return ret;
    }
    public static int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
//            int ret =fa(i);
            sum += fa(i);
        }
        return sum;
    }

    public static void main4(String[] args) {
        System.out.println(sum(5));
    }

    public static void main2(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("第一次调用方法之前");
        int ret = add(a, b);
        System.out.println("第一次调用方法之后");
        System.out.println("ret = " + ret);
        System.out.println("第二次调用方法之前");
        ret = add(30, 50);
        System.out.println("第二次调用方法之后");
        System.out.println("ret = " + ret);
    }

    public static int add(int x, int y) {
        return x + y;
    }
    public static double add(double x,double y){
        return x + y;
    }
    public static float add(float x,float y) {
        return x + y;
    }
    public static boolean isLeapYear(int year) {
        if((0 == year % 4 && 0 != year % 100) || 0 == year % 400){
            return true;
        }else{
            return false;
        }
        //return 代表方法的结束
    }



    public static void main1(String[] args) {
        boolean a  = isLeapYear(2022);
        System.out.println(a);
        int b = add(2,3);
        System.out.println(b);
    }



}
