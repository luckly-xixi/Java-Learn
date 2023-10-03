import com.sun.scenario.effect.Merge;

public class sort4_mergSort {

    public static void process(int[] arr,int L,int R) {
        if(L == R) {
            return;
        }

        int mid = L + ((R - L) >> 1);

        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    public static void merge(int[] arr,int L,int M,int R) {
        int[] help = new int[R-L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;

        while (p1<=M && p2<=R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for(i=0; i<help.length; i++) {
            arr[L + i] = help[i];
        }
        }


        //小合问题
    public static int smallSum(int[] arr) {
        if(arr == null || arr.length < 2) {
            return 0;
        }
        return process2(arr,0,arr.length-1);
    }

    public static int process2(int[] arr, int L, int R ) {
        if(L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process2(arr,L,mid) + process2(arr,mid+1,R) + merge2(arr,L,mid,R);
    }

    public static int merge2(int[] arr,int L,int M,int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        int res = 0;

        while (p1<=M && p2<=R) {
            res += arr[p1]<arr[p2] ? (R-p2+1)*arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for(i=0; i<help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }
}
