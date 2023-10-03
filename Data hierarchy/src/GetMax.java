public class GetMax {

    public static int getMax(int[] arr) {
        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr,int l,int r) {
        if(l == r) {
            return arr[l];
        }

        int mid = l + ((r -l ) >> 1); //中点
        int leftMax = process(arr,l,mid);
        int rightMax = process(arr,mid+1,r);
        return Math.max(leftMax,rightMax);
    }

    //master 公式
    //T(N) = a*T(N/b) + o(N^d)
    //T(N)母问题的规模  a是子问题调用的次数  T(N/b)子问题的规模  o(N^d)除去子问题之外剩下的过程的时间复杂度
}
