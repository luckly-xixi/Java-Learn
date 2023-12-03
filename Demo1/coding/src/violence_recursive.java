import sun.reflect.generics.visitor.Visitor;

import java.util.ArrayList;
import java.util.Stack;

public class violence_recursive {


//汉诺塔问题
    public static void hanoi(int n) {
        if(n > 0) {
            func(n,"左","右","中");
        }
    }

    public static void func(int i,String start,String end,String other) {
        if(i == 1) { // base case
            System.out.println("Move 1 from" + start + "to" + end);
        } else {
            func(i-1,start,other,end);
            System.out.println("Move" + i + "from" + start + "to" + end);
            func(i-1,other,end,start);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

// 打印字符串子集
    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process1(chs,0);
    }

    // 当前来到i位置，要和不要，走两条路
    // 之前的选择，所形成的结果，是str
    public static void process1(char[] str,int i) {
        if(i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        process1(str,i+1);
        char tmp = str[i];
        str[i] = 0;
        process1(str,i+1);
        str[i] = tmp;
    }

// 打印字符串所不重复的有全排列
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process2(chs,0,res);
//        res.sort(null);
        return res;
    }

    // str[i...]范围上，所有的字符，都可以在i位置上，后续都去尝试
    // str[1...i-1]范围上，是之前做的选择
    // 请把所有的字符串形成的全排列，加入到res里去
    public static void process2(char[] str,int i,ArrayList<String> res) {
        if(i == str.length) {
            res.add(String.valueOf(str));
        }

        boolean[] visit = new boolean[26]; // 某一个字符是否试过,去重的字符集
        for(int j=i; j<str.length; j++) {
            if(!visit[str[j] - 'a']) { // 分支限界法
                visit[str[j] - 'a'] = true;
                swap(str,i,j);
                process2(str,i+1,res);
                swap(str,i,j);
            }
        }
    }

    public static void swap(char[] chs,int i,int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }


//决定聪明的抽牌
    public static int win1(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr,0,arr.length-1),s(arr,0,arr.length-1));
    }

    public static int f(int[] arr,int i,int j) {
        if(i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr,i+1,j),arr[j] + s(arr,i,j-1));
    }

    public static int s(int[] arr,int i,int j) {
        if(i == j) {
            return 0;
        }
        return Math.min(f(arr,i+1,j),f(arr,i,j-1));
    }


// 逆序栈

    public static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }
        int i = f1(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int f1(Stack<Integer> stack) {
        int result = stack.pop();
        if(stack.isEmpty()) {
            return result;
        } else {
            int last = f1(stack);
            stack.push(result);
            return last;
        }
    }

//数字数组转为字符串
    public static int process(char[] str,int i) {
        if(i == str.length) {
            return 1;
        }
        if(str[i] == '0') {
            return 0;
        }
        if(str[i] == '1') {
            int res = process(str,i+1); // i自己作为单独的部分，后续有多少种方法
            if(i+1 < str.length) {
                res += process(str,i+2); // （i和i+1）作为单独部分，后续有多少种方法
            }
            return res;
        }
        if(str[i] == '2') {
            int res = process(str,i+1); // i自己作为单独的部分，后续有多少种方法
            // （i和i+1）作为单独的部分并且没有超过26，后续有多少种方法
            if(i+1 < str.length && (str[i+1] >= '0' && str[i+1] <= '6')) {
                res += process(str,i+2); // （i和i+1）作为单独部分，后续有多少种方法
            }
            return res;
        }
        // str[i] == '3' ~ '9'
        return process(str,i+1);
    }

//一堆货物，每个重weight[i] 价值为values[i] 用一个载重为bag的包去装，在不超重的情况下，袋子装的货物的最大价值方案有多少种

    //i... 的货物自由选择，形成的最大价值返回
    //重量永远不要超过bag
    //之前做的决定，所达到的最大重量，alreadyweight
    public static int process3(int[] weights,int[] values,
                               int i,int alreadyweight,int bag) {
        if(alreadyweight > bag) {
            return 0;
        }
        if(i == weights.length) {
            return 0;
        }
        return Math.max(process3(weights,values,i+1,alreadyweight,bag),
                values[i]+process3(weights,values,i+1,
                        alreadyweight+weights[i],bag)
        );
    }
}
