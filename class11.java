import java.util.Scanner;

class New {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class class11 {

    public static int giao(){

        try{
            int[] arrays = {1,2,3};
            System.out.println(arrays[10]);
        }catch (OutOfMemoryError e){
            return 1;
        }finally {
            return 9;
        }
    }

    public static void main(String[] args) {
//建议别再finally里写return语句
        System.out.println(giao());

    }

    public static void main10(String[] args) {
        //finally一般用于资源的释放
//        Scanner scanner = new Scanner(System.in);
        //打开Scanner资源
//        try
        try(Scanner scanner = new Scanner(System.in)){
            int[] arrays = {1,2,3};
            System.out.println(arrays[10]);
        }catch (OutOfMemoryError e){
            e.printStackTrace();
            System.out.println("捕捉到OutOfMemoryError  异常");
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("捕捉到了NullPointerException  异常");
        }finally {
//            scanner.close();
            //使用完成后释放Scanner资源
            System.out.println("finally执行");
        }

        System.out.println("正常的逻辑");
    }

    private static void off(String a) {
        if (a == null) {
            throw new NullPointerException();
        }
    }

    public static void main9(String[] args) {
//catch未捕捉到异常，交给JVM中断程序
        try{
            int[] arrays = {1,2,3};
            System.out.println(arrays[10]);
        }catch (OutOfMemoryError e){
            e.printStackTrace();
            System.out.println("捕捉到OutOfMemoryError  异常");
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("捕捉到了NullPointerException  异常");
        }finally {
            System.out.println("finally执行");
        }

        System.out.println("正常的逻辑");

    }

    public static void main8(String[] args) {
//程序正常执行
        try{
            int[] arrays = {1,2,3};
            System.out.println(arrays[2]);
        }catch (OutOfMemoryError e){
            e.printStackTrace();
            System.out.println("捕捉到OutOfMemoryError  异常");
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("捕捉到了NullPointerException  异常");
        }finally {
            System.out.println("finally执行");
        }

        System.out.println("正常的逻辑");

    }

    public static void main7(String[] args) {
//catch捕捉到异常
        try{
            int[] arrays = {1,2,3};
            System.out.println(arrays[10]);
        }catch (OutOfMemoryError e){
            e.printStackTrace();
            System.out.println("捕捉到OutOfMemoryError  异常");
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("捕捉到了ArrayIndexOutOfBoundsException  异常");
        }finally {
            System.out.println("finally执行");
        }

        System.out.println("正常的逻辑");

    }

    //catch中没有指定的异常
    //只会交给JVM处理，就直接中断程序
    public static void main6(String[] args) {

        try {
            int[] arrays = {1,2,3};
            System.out.println(arrays[10]);
        }catch (NullPointerException e){
            e.printStackTrace();//打印栈上的异常信息
            System.out.println("捕捉到NullPointerException 异常，进行处理异常的逻辑");
        }/*catch (ArrayIndexOutOfBoundsException e){
            System.out.println("捕捉到了ArrayIndexOutOfBoundsException  异常");
        }*//*catch (Exception e){
            e.printStackTrace();//打印栈上的异常信息
            System.out.println("捕捉到Exception 异常，进行处理异常的逻辑");
        }*/

        System.out.println("正常的逻辑");

    }

    //Exception可以捕获到所有异常，如果放到catch第一个
    //后续的异常没有任何的作用了
    public static void main5(String[] args) {

        try {
            off(null);
        }catch (Exception e){
            e.printStackTrace();//打印栈上的异常信息
            System.out.println("捕捉到NullPointerException 异常，进行处理异常的逻辑");
        }/*catch (ArrayIndexOutOfBoundsException e){
            System.out.println("捕捉到了ArrayIndexOutOfBoundsException  异常");
        }*/

        System.out.println("正常的逻辑");

    }

    //多次异常一次捕捉
    public static void main4(String[] args) {

        try {
            off(null);
        }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
            e.printStackTrace();//打印栈上的异常信息
            System.out.println("捕捉到NullPointerException | ArrayIndexOutOfBoundsException 异常，进行处理异常的逻辑");
        }

        System.out.println("正常的逻辑");

    }

    //处理异常
    public static void main3(String[] args) {
        try {
            off(null);
        }catch (NullPointerException e){
            e.printStackTrace();//打印栈上的异常信息
            System.out.println("捕捉到NullPointerException 异常，进行处理异常的逻辑");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("捕捉到了ArrayIndexOutOfBoundsException  异常");
        } /*catch (CloneNotSupportedException e){
            System.out.println("捕捉到了CloneNotSupportedException  异常");
        }*/
        System.out.println("正常的逻辑");
    }

    //通过throw关键字主动去抛出异常
    public static void main2(String[] args) {
        off(null);
    }

    public static void main1(String[] args) throws CloneNotSupportedException {
        //算数异常
//        System.out.println(10/0);

        //空指针异常    在程序抛出异常后未处理，则异常报错之后的代码将不会被执行。
       /* int[] arrays = null;
        System.out.println(arrays.length);*/

        //类型转换异常
        New new1 = new New();
//        New new1 = new New()；  语法错误
        New new2 = (New) new1.clone();
    }

}
