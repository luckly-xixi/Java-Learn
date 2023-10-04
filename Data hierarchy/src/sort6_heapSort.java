import java.util.PriorityQueue;

public class sort6_heapSort {


    public static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        //建立大根堆
        for(int i=0; i<arr.length; i++) { // O(N)
            heapInsert(arr,i); // O(logN）
        }

//        for(int i=arr.length-1; i>=0; i++) {
//            heapify(arr,i,arr.length);
//        }

        int heapSize = arr.length;
        swap(arr,0,--heapSize);

        while(heapSize > 0) { // O(N)
            heapify(arr,0,heapSize); //O(logN)
            swap(arr,0,--heapSize); // O(1)
        }
    }

    //某个数现在的处在index位置，往上继续移动
    public static void heapInsert(int[] arr,int index) {
        while(arr[index] > arr[(index - 1) / 2]) {
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr,int index,int heapSize) {
        int left = index * 2 + 1; //左孩子下标

        while(left < heapSize) { //下方还有孩子的时候
            //两个孩子中，谁的值大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1 : left;

            //父和较大的孩子之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;

            if(largest == index) {
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }




    //几乎有序数组（每个元素相差不超过k）的合适排序算法
    public void sortedArrDistanceLessK(int[] arr,int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for(; index<=Math.min(arr.length,k); index++) {
            heap.add(arr[index]);
        }

        int i = 0;
        for(; index<arr.length; i++,index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while(!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
