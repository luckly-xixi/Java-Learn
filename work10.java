<<<<<<< HEAD
public class work10 {


//给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
    class Solution1 {
        public String toLowerCase(String s) {
            //    s=s.toLowerCase();
            //   return s;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (ch >= 65 && ch <= 90) {
                    ch |= 32;
                }
                sb.append(ch);
            }
            return sb.toString();
        }
    }

    //统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
    //
    //
    //
    //请注意，你可以假定字符串里不包括任何不可打印的字符。
    class Solution {
        public int countSegments(String s) {

            int count = 0;

            for(int i=0;i<s.length();i++){
                if((i == 0 ||s.charAt(i-1)==' ')&& s.charAt(i)!=' '){
                    count++;
                }
            }

            return count;
        }
    }
}
=======
public class work10 {


//给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
    class Solution1 {
        public String toLowerCase(String s) {
            //    s=s.toLowerCase();
            //   return s;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (ch >= 65 && ch <= 90) {
                    ch |= 32;
                }
                sb.append(ch);
            }
            return sb.toString();
        }
    }

    //统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
    //
    //
    //
    //请注意，你可以假定字符串里不包括任何不可打印的字符。
    class Solution {
        public int countSegments(String s) {

            int count = 0;

            for(int i=0;i<s.length();i++){
                if((i == 0 ||s.charAt(i-1)==' ')&& s.charAt(i)!=' '){
                    count++;
                }
            }

            return count;
        }
    }
}
>>>>>>> f3133e3d7961ab08b5abbcab2cc13211ae745965
