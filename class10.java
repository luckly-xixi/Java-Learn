import java.util.Locale;
import java.util.Scanner;

//Spring类
public class class10 {

    public boolean isPalindrome(String s){
        s = s.toLowerCase();//全部转为小写

        int left = 0;
        int right = s.length()-1;

        while (left < right){
            while (left < right && isValidChar(s.charAt(left))){
                left++;
            }
            //left是有效字符
            while (left < right && isValidChar(s.charAt(right))){
                right--;
            }
            //right是有效字符
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;

    }

    private Boolean isValidChar(char ch){
//        if(ch >= 0 && ch <= 9 || ch >= 'a' && ch <= 'z'){
        if(Character.isLetter(ch) || Character.isDigit(ch)){
            return true;
        }
    return false;
    }
    //计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
    public static void main111(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            //将输入的字符串给str
            int index = str.lastIndexOf(" ");
            //找到str里面最后一个空格隔开的位置
            String tmp = str.substring(index + 1);
            //从index紧挨着的后一个位置开始截取字符串
            System.out.print(tmp.length());
        }
    }

////给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1
//    public int firstUniqChar(String s){
////        int[] count = new int[256];
//        int[] count = new int[26];
//        //统计每个字符出现的次数
//        for (int i = 0; i < s.length(); i++) {
////            count[s.charAt(i)]++;
//            count[s.charAt(i)-'a']++;
//        }
//        //找第一个出现1次的字符
//        for (int i = 0; i < s.length(); i++) {
//            if(1 == count[s.charAt(i)-'a']){
//                return i;
//           }
//        }
//        return -1;
//    }

        public static void main23 (String[]args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) ;
        }
        public static void main22 (String[]args){

            StringBuilder stringBuilder = new StringBuilder("abc");
            System.out.println(stringBuilder);//abc

            stringBuilder.append(" 123").append(10);
            stringBuilder.append(19.9);

            System.out.println(stringBuilder);//abc 1231019.9
            //此时不会产生临时对象
        }

        public static void main21 (String[]args){

            long start = System.currentTimeMillis();
            String s = "";

            for (int i = 0; i < 10000; ++i) {
                s += i;
            }

            long end = System.currentTimeMillis();
            System.out.println(end - start);


            start = System.currentTimeMillis();
            StringBuffer sbf = new StringBuffer("");

            for (int i = 0; i < 10000; ++i) {
                sbf.append(i);
            }

            end = System.currentTimeMillis();
            System.out.println(end - start);

            start = System.currentTimeMillis();
            StringBuilder sbd = new StringBuilder();
            for (int i = 0; i < 10000; ++i) {
                sbd.append(i);
            }
            end = System.currentTimeMillis();
            System.out.println(end - start);
        }

        public static void main20 (String[]args){
            //
            String str = "abcd";
            System.out.println(str);
        }

        public static void main19 (String[]args){

            String str1 = "abcd";
            String str2 = new String("abcd");
            System.out.println(str1 == str2);//false

            String str3 = "abcd";
            System.out.println(str1 == str3);//true
        }

        public static void main18 (String[]args){
            String str = "   hello   world   ";
            //只去掉字符串开头和结尾的空白字符
            System.out.println(str);//[   hello   world   ]
            String tmp = str.trim();
            System.out.println(tmp);//[hello   world]
        }

        //字符串的截取
        public static void main17 (String[]args){
            //
            String str = "1s5s3a7e";
            //从下标2开始截取后面的字符内容
            String tmp1 = str.substring(2);
            System.out.println(tmp1);//5s3a7e

            //从下标2开始截取到下标5截止（不包括下标5），区间是左闭右开的[)
            String tmp2 = str.substring(2, 5);
            System.out.println(tmp2);//5s3
        }

        //分割字符串
        public static void main16 (String[]args){
            String str = "192.168.1.1";
//        String[] tmp = str.split(".",2);
            String[] tmp = str.split("\\.", 2);
            for (String i : tmp) {
                System.out.println(i);
            }
//        192
//        168.1.1
            String str2 = "192\\168\\1\\1";
            String[] tmp2 = str2.split("\\\\", 2);
            for (String i : tmp2) {
                System.out.println(i);
            }
//        192
//        168\1\1


            String str3 = "1+2=3";
            String[] tmp3 = str3.split("\\+");
            for (String i : tmp3) {
                System.out.println(i);
//            1
//            2=3
            }
            String[] tmp4 = str3.split("\\+|=");
            for (String i : tmp4) {
                System.out.println(i);
//            1
//            2
//            3
            }

            //多次分割
            String str4 = "name=zhangsan&age=18";
            String[] tmp5 = str4.split("&");
            for (int i = 0; i < tmp5.length; i++) {
//            System.out.println(tmp5[i]);
//            name=zhangsan
//            age=18
                //通过调用分割后的字符串再次进行分割
                String[] strings = tmp5[i].split("=");
                for (String s : strings) {
                    System.out.println(s);
                }
//            name
//            zhangsan
//            age
//            18
            }


        }

        //字符串的分割
        public static void main15 (String[]args){
            String str1 = "yi li wo li giao";
            String[] tmp = str1.split(" ");// 按照空格拆分
            for (int i = 0; i < tmp.length; i++) {
                System.out.println(tmp[i]);
            }
            String[] tmp2 = str1.split(" ", 2);
            for (int i = 0; i < tmp2.length; i++) {
                System.out.println(tmp[i]);
            }
        }

        public static void main14 (String[]args){
            //单个字符串替换
            String str1 = "123123123123";
            String ret1 = str1.replace('1', 'e');//e23e23e23e23
            System.out.println(ret1);

            //多个字符替换
            String ret2 = str1.replace("12", "zx");//zx3zx3zx3zx3
            System.out.println(ret2);

            //替换所有的指定内容
            String str3 = "123451237128128";
            String tmp = str3.replaceAll("12", "giao");
            System.out.println(tmp);//giao345giao37giao8giao8

            //替换首个内容
            String tmp2 = str3.replaceFirst("12", "woqu");
            System.out.println(tmp2);//woqu3451237128128
        }

        public static void main13 (String[]args){
            //以格式化的形式放到字符串当中
            String str12 = String.format("%d-%d-%d", 2022, 12, 12);
            System.out.println(str12);//2022-12-12
        }

        public static void main12 (String[]args){
            //字符串转数组
            String str1 = "abcdef";
            char[] array = str1.toCharArray();
            System.out.println(array[1]);//b
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }

            //字符串转数组
            String str2 = new String(array);
            System.out.println(str2);
        }

        public static void main11 (String[]args){
            //只会把字母大小写转换
            String str1 = "hello";
            String str2 = "HELLO";
            // 小写转大写
            System.out.println(str1.toUpperCase());//HELLO
            // 大写转小写
            System.out.println(str2.toLowerCase());//hello
            String str3 = "Hello";
            System.out.println(str3.toUpperCase());//HELLO
        }

        public static void main10 (String[]args){
            //数字转字符串
            String str1 = String.valueOf(123);
            System.out.println(str1);
            //类型转字符串
            String str2 = String.valueOf(new Persons("ss", 2));
            System.out.println(str2);

            System.out.println("============");

            //字符串转数字
            String str3 = "123";
            int data1 = Integer.parseInt(str3);
            System.out.println(data1);
            double data2 = Double.parseDouble(str3);
            System.out.println(data2);
        }

        //int lastIndexOf(String str)和int lastIndexOf(String str, int fromIndex)
        public static void main9 (String[]args){
            String str1 = "ababcabcdabcde";
            System.out.println(str1.lastIndexOf("abc"));//9
            //从str1字符串(主串)最后往前找字符串abc（字串）首次出现的位置并返回该下标
            System.out.println(str1.lastIndexOf("abc", 8));//5
            //从str1字符串(主串)8下标位置往前找字符串abc（字串）首次出现的位置并返回该下标
        }

        //int lastIndexOf(int ch)和int lastIndexOf(int ch, int fromIndex)
        public static void main8 (String[]args){
            String str1 = "ababcabcdabcde";
            System.out.println(str1.lastIndexOf('c'));//11
            //从str1字符串最后往前找字符c首次出现的位置并返回该下标
            System.out.println(str1.lastIndexOf('c', 8));//7
            //从str1字符串8下标往前找字符c首次出现的位置并返回该下标
        }

        //int indexOf(String str)和int indexOf(String str, int fromIndex)
        public static void main7 (String[]args){
            String str1 = "ababcabcdabcde";
            System.out.println(str1.indexOf("abc"));//2
            //查找str1主串当中从0下标开始abc字符串（字串）出现的位置，并返回子串首字符出现的下标
            System.out.println(str1.indexOf("abc", 5));//5
            //查找str1主串当中从5下标开始abc字符串（字串）出现的位置，并返回子串首字符出现的下标
        }

        //int indexOf(int ch)和int indexOf(int ch, int fromIndex)
        public static void main6 (String[]args){
            String str1 = "ababcabcdabcde";
            System.out.println(str1.indexOf('c'));//4
            //返回c第一次出现的位置（并返回他所在位置的下标），从0下标开始遍历数组
            System.out.println(str1.indexOf('c', 6));//7
            //从6下标开始找字符c第一次出现的位置，并返回它所在位置的下标
        }

        //char charAt(int index)
        public static void main5 (String[]args){
            String str2 = "hello";
            System.out.println(str2.charAt(0));//h
            System.out.println(str2.charAt(1));//e
            System.out.println(str2.charAt(2));//l

            for (int i = 0; i < str2.length(); i++) {
                System.out.println(str2.charAt(i));//遍历打印数组
            }
        }

        //按照字典序进行比较
        public static void main4 (String[]args){
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
        public static void main3 (String[]args){
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

        public static void main2 (String[]args){

            String str1 = "Hello";
            System.out.println(str1.length());
            //这里面调用的是方法所以length（）是带括号的
            int[] array = {1, 2, 3, 4};
            System.out.println(array.length); // 获取字符串长度---输出5
            //这里面的length只是类似于是一个属性
            System.out.println("hello".length());//调用方法的时候 . 的前面不一定是一个对象，也可以是一个常量。
            String str2 = "";//str2指向的对象里面是空的
            System.out.println(str2.length());
            System.out.println(str2.isEmpty()); // 如果字符串长度为0，返回true，否则返回false
            String str3 = null;//str3不指向任何对象
        }

        public static void main1 (String[]args){

            String str = "Hello";// 使用常量串构造
            String str2 = new String("Hello");// 直接newString对象
            //两种方法本质相同，第二种是第一种的简写
            System.out.println(str);//Hello
            System.out.println(str2);//Hello

            // 使用字符数组进行构造
            char value[] = {'H', 'e', 'l', 'l', 'o'};
            String str3 = new String(value);
            System.out.println(str3);//Hello
        }

    }

