import java.util.Scanner;

public class Winterwork {


    public static void main2(String[] args) {

        //2、编写程序，对输入的年、月、日，给出该天是该年的第多少天？
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入对应的年月日，例如：2023-01-02");
        String s = scanner.nextLine();
        String[] arrays = s.split("-",3);
       /* for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }*/
        boolean isleapyear = false;
        int year = Integer.parseInt(arrays[0]);
        int moonth = Integer.parseInt(arrays[1]);
        int day = Integer.parseInt(arrays[2]);
        int[] days = new int[12];
        int sumday = 0;
        //判断是否是闰年
        if(year%400==0||(year%4==0 && year%100 !=0)){
            isleapyear = true;
        }
        //判断月份,并且赋予相应的数值
        for (int i = 1; i < moonth; i++) {
            if(i == 2){
                if(isleapyear == true){
                    days[i] = 29;
                }else {
                    days[i] = 28;
                }
            }else if(i==4 && i==6 && i==9 && i==11) {
                days[i] = 30;
            }else {
                days[i] = 31;
            }
            sumday += days[i];
        }
        sumday += day;

        System.out.println("是该年的第"+sumday+"天");
    }

    public static void main1(String[] args) {

        //day1
        //1、编写程序，输入一个字符，判断它是否为小写字母，如果是，将它转换成大写字母，否则，不转换
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
//        System.out.println(s.toString());
//        System.out.println(s.toUpperCase());
        String a = "a";
//
        if(s.compareTo(a) == 0){
            System.out.println(s.toUpperCase());
        }
    }


}
