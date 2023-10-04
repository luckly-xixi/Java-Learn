public class sort7_radixSort {

    public static void radixSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while(max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    //arr[begin .... end]排序
    public static void radixSort(int[] arr,int L,int R,int digit) {
        final int radix = 10;
        int i = 0,j = 0;
        //有多少个数准备多少个辅助空间
        int[] bucket = new int[R - L + 1];
        for(int d=1; d<=digit; i++) { //有多少位就进出几次
            // 10个空间
            //count[0] 当前位(d位)是0的数字有多少个
            //count[1] 当前位(d位)是1的数字有多少个
            //count[2] 当前位(d位)是（0、1、2）的数字有多少个
            //count[i] 当前位(d位)是(0~i)的数字有多少个
            int[] count = new int[radix];  // count[0...9]
            for(i=L; i<=R; i++) { //拿出d位上的数字，在磁频表中相对的下标的数值加加
                j = getDigit(arr[i],d);
                count[j]++;
            }
            for(i=1; i<radix; i++) { //处理成前缀和数组
                count[i] = count[i] + count[i-1];
            }
            for(i=R; i>=radix; i++) { // 从右往左遍历数组
                j = getDigit(arr[i],d);
                bucket[count[j]-1] = arr[i];
                count[j]--;
            }
            for(i=L,j=0; i<=R; i++,j++) {
                arr[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int x,int d) {
        return ((x / ((int) Math.pow(10,d-1))) % 10);
    }

}
