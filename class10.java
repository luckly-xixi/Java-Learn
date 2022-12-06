//Spring类
public class class10 {

    public static void main(String[] args) {

        String str1 = "Hello";
        System.out.println(str1.length());
        //这里面调用的是方法所以length（）是带括号的
        int[] array = {1,2,3,4};
        System.out.println(array.length); // 获取字符串长度---输出5
        //这里面的length只是类似于是一个属性
        System.out.println("hello".length());//调用方法的时候 . 的前面不一定是一个对象，也可以是一个常量。
        String str2 = "";//str2指向的对象里面是空的
        System.out.println(str2.length());
        System.out.println(str2.isEmpty()); // 如果字符串长度为0，返回true，否则返回false
        String str3 = null;//str3不指向任何对象
    }

    public static void main1(String[] args) {

        String str = "Hello";// 使用常量串构造
        String str2 = new String("Hello");// 直接newString对象
        //两种方法本质相同，第二种是第一种的简写
        System.out.println(str);//Hello
        System.out.println(str2);//Hello

        // 使用字符数组进行构造
        char value[] = {'H','e','l','l','o'};
        String str3 = new String(value);
        System.out.println(str3);//Hello
    }

}
