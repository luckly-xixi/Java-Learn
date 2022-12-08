//Spring类
public class class10 {

    //按照字典序进行比较
    public static void main4(String[] args) {
        //字符串长度相同
        String str1 = new String("Hello");
        String str2 = new String("Healo");
        //str1 和 str2 进行比较
        System.out.println(str1.compareTo(str2));//11
        String str3 = new String("Healo");
        String str4 = new String("Hello");
        System.out.println(str3.compareTo(str4));//-11

        String str5 = new String("Hello");
        String str6 = new String("Hello");
        System.out.println(str5.compareTo(str6));//0

        //字符串长度不同
        String tmp1 = new String("Helloabc");
        String tmp2 = new String("Hello");
        System.out.println(tmp1.compareTo(tmp2));//3
        String tmp3 = new String("hello");
        String tmp4 = new String("Hello");
        //忽视两个字符串的大小写进行比较
        //注意：汉字是不能忽略大小写的
        System.out.println(tmp3.compareToIgnoreCase(tmp4));//0
    }

    //字符串比较
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "Hello";
        String str4 = new String("Hello");
        String str5 = new String("Hello");
//        String str5 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str4 == str5);
        //比较两个引用所指向的对象 里的内容是否一致
        System.out.println(str4.equals(str5));
//        System.out.println(str4.equalsIgnoreCase(str5));//忽略大小写
    }

    public static void main2(String[] args) {

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
