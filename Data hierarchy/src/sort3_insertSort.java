public class sort3_insertSort {

    public static void insertionSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        for(int i=1; i<arr.length; i++) {// 0 ~ i 有序

            for(int j=i-1; j>=0 && arr[j] > arr[j+1]; j--) {
                swap(arr,j,j+1);
            }
        }
    }

    public static void swap(int[] arr,int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
