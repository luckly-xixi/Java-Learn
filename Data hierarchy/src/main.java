import java.util.Arrays;

public class main {

    public static void main(String[] args) {
        int[] arr = {2,4,5,1,3,6,8,7,9,0};
        int[] arr2 = {1,3,4,2,5};
//        sort1_selectionSort.selectionSort(arr);
//        sort2_bubbleSort.bubbleSort(arr);
//        sort3_insertSort.insertionSort(arr);
//        sort4_mergSort.process(arr,0,arr.length-1);
        int a = sort4_mergSort.smallSum(arr2);

        System.out.println(Arrays.toString(arr2));
        System.out.println(a);
//        System.out.println(arr.length);
//        System.out.println(arr.length - 1);
    }

    //一堆数中，只有一个数字出现奇数次，其余的数出现偶数次
    public static void printtOddTimeNum1(int[] arr) {
        int eor = 0;
        for(int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

    //一堆数中，有两个数字出现奇数次，其余的数出现偶数次
    public static void printtOddTimeNum2(int[] arr) {
        int eor = 0, onlyOne = 0;
        for(int curNum : arr) {
            eor ^= curNum;
        }
        //eor = a ^ b
        //eor != 0
        //eor 必然有一个位置上是1
        int rightOne = eor & (~eor + 1);//提取出最右边的1
        for(int cur : arr) {
            if((cur & rightOne) == 1) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    //对数器
    public static int[] generateRandomArray(int maxSize,int maxValue) {

        //Math.random() -> [0,1) 所有的小数，等概率返回一个
        //Math.random() * N -> [0.N) 所有小数，等概率返回一个
        //(int)(Math.random() * N) -> [0,N-1] 所有整数，等概率返回一个

        int[] arr = new int[(int)((maxSize + 1) * Math.random())]; //长度随机

        for(int i=0; i<arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)((maxValue * Math.random()));
        }

        return arr;
    }
}
