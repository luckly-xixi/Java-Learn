public class sort2_bubbleSort {

    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        for(int e = arr.length-1; e > 0; e--) { //多少轮
            for(int i = 0; i < e; i++) { //每轮的执行
                if(arr[i] > arr[i+1]) {
                    swap(arr,i,i+1);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
