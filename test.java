import java.util.Arrays;
import java.util.Scanner;

//输入一个字符串，求出该字符串包含的字符集合



//题目
//        输入一个字符串，求出该字符串包含的字符集合。
//        输入描述
//        每组数据输入一个字符串，字符串最大长度为100，且只包含字符，不能为空串，区分大小写。
//        输出描述
//        每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。


//        输入
//        abcqwerabc
//        输出
//        abcqwer

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        if (str1.length()>100||str1 == null) {
            return;
        }
        for (int i = 0; i < str1.length(); i++) {
            for (int j = i+1; j < str1.length();j++) {
                if(str1.charAt(i) == str1.charAt(j)){
                    str1 = str1.substring(0,j)+str1.substring(j+1,str1.length());
                }
            }
        }
        System.out.print(str1);
        }
    }

//合并两个有序数组（java算法）

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //把数组2替换掉数组1里的0，然后.sort()排序。我真是魔鬼（dog脸）
        int q = 0;
        for(int i = 0;i < nums1.length;++i){
            if(nums1[i] == 0){
                nums1[i] = nums2[q];
                q++;
            }
            if(q == n){
                break;
            }
        }
        Arrays.sort(nums1);
    }
}


