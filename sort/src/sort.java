import com.sun.scenario.effect.Merge;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;

public class sort {

    public static void main(String[] args) {
        int[] arr = {2,4,5,1,3,6,8,7,9,0};
//        bubbleSort(arr);
//        quickSort(arr,0,arr.length-1);
//        insertSort(arr);
//        shellSort(arr);
//        selectionSort(arr);
//        heapSort(arr);
//        mergeSort(arr,0,arr.length-1);
//        countSort(arr);
//        bucketSort(arr);
        radioxSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    //冒泡排序
    public static void bubbleSort(int[] arr) {
        //趟数 o(n^2)
        for(int i=1; i<arr.length; i++) {
            //i=1  j=4
            //i=2  j=3
            for(int j=0; j<=arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                   int temp =  arr[j] ;
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                }
            }
        }
    }


    public static void swap(int[] arr,int i,int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }

    //快排 o(n*lgn)或者o(n^2)
    public static void quickSort(int[] arr,int low,int high) {
        if(high > low) {
            int i = low;
            int j = high;

            while(i < j) {
             //从后向前
                while (i<j && arr[j]>=arr[i]) {
                    j--;
                }
                //交换
                swap(arr,i,j);

             //从前向后
                while(i<j && arr[i]<=arr[j]) {
                    i++;
                }

                //交换
                swap(arr,i,j);
            }
            //递归左右两部分
            quickSort(arr,low,j-1);
            quickSort(arr,j+1,high);
        }
    }


    //插入排序 o(n^2)
    public static void insertSort(int[] arr) {
        //趟数
        for(int i=1; i<arr.length; i++) {
            //比较
            for(int j=i; j>0; j--) {
                if(arr[j] < arr[j-1]) {
                    swap(arr,j,j-1);
                }
            }
        }
    }

    //希尔排序 o(n*lg^n) - o(n^2)
    public static void shellSort(int[] arr) {
        //区间划分
        for(int gap=arr.length/2; gap>0; gap/=2) {
            //不同区间的插入排序
            for(int i=gap; i<arr.length; i++) {
                //元素比较
                for(int j=i; j>=gap; j-=gap) {
                    if(arr[j] < arr[j-gap]) {
                        swap(arr,j,j-gap);
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }



    //选择排序 o(n^2)
    public static void selectionSort(int[] arr) {
        //趟数
        for(int i=0; i<arr.length-1; i++) {
            //每趟里面的最小值
            int min_index = i;
            for(int j=i; j<arr.length; j++) {
                if(arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            swap(arr,i,min_index);
        }
    }

    //堆排序 o(n*logn)
    public static void heapSort(int[] arr) {
        //建堆
        for(int i=arr.length/2-1; i>=0; i--) {
            heapify(arr,i,arr.length-1);
        }
        //排序
        for(int i=arr.length-1; i>0; i--) {
            //让根节点沉底，交换后忽略最后一个叶子节点
            swap(arr,0,i);
            //从根节点开始对堆进行调整
            heapify(arr,0,i-1);
        }
    }
    public static void heapify(int[] arr,int i,int last_index) {
        int max = i;
        //左孩子节点
        if(2*i+1 <= last_index && arr[max] < arr[2*i+1]) {
            max = 2*i+1;//更新最大值的下标
        }
        //右孩子节点
        if(2*i+2 <= last_index && arr[max] < arr[2*i+2]) {
            max = 2*i+2;//更新最大值下标
        }
        //判断max是否被更新
        if(max != i) {
            //交换根节点和最大值
            swap(arr,i,max);
            //交换之后对最大值进行递归比较（交换过程可能破坏了堆结构）
            heapify(arr,max,last_index);
        }
    }


    //归并排序 o(n*logn)
    public static void mergeSort(int[] arr, int low,int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            //左归并
            mergeSort(arr,low,mid);
            //右归并
            mergeSort(arr,mid+1,high);

            //合并
            merge(arr,low,mid,high);
        }
    }
    public static void merge(int[] arr,int low, int mid, int high ) {
        int[] temp = new int[arr.length];

        int i = low;
        int j= mid+1;
        int k = 0;

        //两路大小数值比较
        while(i<=mid && j<=high) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        //其中一路没数据了
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        k=0;
        while (low <= high) {
            arr[low++] = temp[k++];
        }
    }

    //计数排序 o(n+k)
//    public static void countSort(int[] arr) {
//        int max = 0;
//        //遍历数组找最大值来创建计数数组
//        for(int i=0; i<arr.length; i++) {
//            if(arr[i] > max) {
//                max = arr[i];
//            }
//        }
//
//        int[] count = new int[max+1];
//
//        //遍历数组开始计数
//        for (int i=0; i<arr.length; i++) {
//            count[arr[i]]++;
//        }
//
//        int k = 0;
//        for(int i=0; i<count.length; i++) {
//            while(count[i] > 0) {
//                arr[k++] = i;
//                count[i]--;
//            }
//        }
//    }
    public static void countSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //遍历数组找最大值来创建计数数组
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        int[] count = new int[max-min+1];

        //遍历数组开始计数
        for (int i=0; i<arr.length; i++) {
            count[arr[i]-min]++;
        }

        int k = 0;
        for(int i=0; i<count.length; i++) {
            while(count[i] > 0) {
                arr[k++] = i + min;
                count[i]--;
            }
        }
    }



    //桶排序
    public static void bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //找到最大最小值
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        //确定桶的数量
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        int count = (max - min) / arr.length +1;
        for(int i=0; i<count; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        //遍历元素放入桶
        for(int i=0; i<arr.length; i++) {
            buckets.get((arr[i]-min)/arr.length).add(arr[i]);
        }
        //每个桶排序
        for(int i=0; i<buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }

        int k = 0;
        //遍历桶
        for(int i=0; i<buckets.size(); i++) {
            ArrayList<Integer> list = buckets.get(i);
            for(int j=0; j<list.size(); j++){
                arr[k++] = list.get(j);
            }
        }
    }



    //基数排序
    public static void radioxSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        //分解数字
        for(int exp=1; max/exp>0; exp*=10) {
            //创建10个桶
            int[] buckets = new int[10];
            //创建temp数组
            int[] temp = new int[arr.length];

            //计算每个桶中数据的个数
            for(int i=0; i<arr.length; i++) {
                buckets[arr[i]/exp%10]++;
            }
            //计算每个桶中的累计数据
            for(int i=1; i<buckets.length; i++) {
                buckets[i] += buckets[i-1];
            }

            //从后往前遍历数组arr，放在temp
            for(int i=arr.length-1; i>=0; i--) {
                temp[buckets[arr[i]/exp%10]-1] = arr[i];
                buckets[arr[i]/exp%10]--;
            }
            for(int i=0; i<temp.length; i++) {
                arr[i] = temp[i];
            }

        }
    }
}
