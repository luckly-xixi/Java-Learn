public class NQueens {


    //n皇后问题
    public static int num1(int n) {
        if(n<1) {
            return 0;
        }

        int[] record = new int[n]; // record[i]  ->  i行的皇后放在了第几列
        return process1(0,record,n);
    }


    //record[0~i-1]  任何两个皇后一定不共行、不共列、不共斜线
    //目前是第i行
    //record[0~i-1]  表示之前的行，放的皇后的位置
    //n 代表一共多少行
    //返回值是合法的皇后摆法
    public static int process1(int i,int[] record,int n) {
        if(i == n) { // 终止行
            return 1;
        }

        int res = 0;
        for(int j=0; j<n; j++) {// 当前在i行，尝试i行的所有列的合法性

            if(isValid(record,i,j)) { // 如过这个列合格
                record[i] = j;
                res += process1(i+1,record,n);
            }
        }
        return res;
    }


    public static boolean isValid(int[] record ,int i,int j) {
        for(int k=0; k<i; k++) {
            if(j == record[k] || Math.abs(record[k]-j) == Math.abs(i-k)) {
                return false;
            }
        }
        return true;
    }


//常数优化版本(二进制位信息)
    public static int num2(int n) {
        if(n<1 || n>32) {
            return 0;
        }
        int limit = n == 32? -1 : (1 << n) - 1;
        return process2(limit,0,0,0);
    }

    public static int process2(int limit,
                               int colLim,
                               int leftDiaLim,
                               int rightDiaLim) {
        if(colLim == limit) { // 说明所有皇后放完了
            return 1;
        }
        int mostRightOne = 0;
        int pos = 0;

        pos = limit & (~(colLim | leftDiaLim | rightDiaLim));//可以放皇后的位置

        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1); // 提取出pos的最右边的1
            res += process2(limit,
                    colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim| mostRightOne) >>> 1);
        }
        return res;
    }
}
