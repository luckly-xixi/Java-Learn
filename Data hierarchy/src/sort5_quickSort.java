public class sort5_quickSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void quickSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr,int L,int R) {
        if(L < R) {
            swap(arr,L + (int)(Math.random() * (R - L + 1)),R);
            int[] p = partition(arr,L,R);
            quickSort(arr,L,p[0]-1);// < 区域
            quickSort(arr,p[1]+1,R);// > 区域
        }
    }

    public static int[] partition(int[] arr,int L,int R) {
        int less = L - 1;// < 区域右边界
        int more = R;// > 区域左边界
        while (L < more) { // L 表示当前数的位置 arr[R] -> 划分值
            if(arr[L] < arr[R]) { // 当前数 < 划分值
                swap(arr,++less,L++);
            } else if(arr[L] > arr[R]) { // 当前数 > 划分值
                swap(arr,--more,L);
            }else {
                L++;
            }
        }
        swap(arr,more,R);
        return new int[] { less + 1, more};
    }
}
