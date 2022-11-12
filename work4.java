import java.util.Arrays;
import java.util.Scanner;

public class work4 {

    public static void main(String[] args) {
        //给你一个整数数组 arr，
        // 请你判断数组中是否存在连续三个元素都是奇数的情况：
        // 如果存在，请返回 true ；否则，返回 false 。
        int[] array = {2,6,4,1};
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) {
                count = 0;
            } else  {
                count++;
            }
            if(count == 3) {
                System.out.println("true!");
            break;
            }
        }
       if(count != 3) {
           System.out.println("false!");
       }
    }
    public static boolean isThreeOdd (int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                count = 0;
            } else {
                count++;
                if (count == 3) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main7(String[] args) {
        //给定一个整数数组 nums 和一个整数目标值 target，
        // 请你在该数组中找出 和为目标值 target 的那 两个 整数，
        // 并返回它们的数组下标。
        int[] array1 = {2,7,11,15,3,6};
        int target = 10;
        for (int i = 0; i < array1.length-1; i++) {
            for (int j = i+1; j < array1.length-1; j++) {
                if(array1[i] + array1[j] == target) {
                    System.out.println("找到了下标是"+i+"和"+j);
                    return;
                }
            }
        }
        System.out.println("找不到");

       // System.out.println(Arrays.toString(findTarget(array1,target)));
    }

    public static int[] findTarget(int[] array,int target) {
        int[] ret= {1,-1};
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if(array[i] + array[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                }
            }
        }
        return ret;
    }

    public static void main6(String[] args) {
        //给定一个大小为 n 的数组，找到其中的多数元素。
        // 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
        int[] array = {2, 3, 2, 3, 3, 3,};
        int ret = findMoreNum1(array);
        System.out.println(ret);
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            if (i == 0) {
                for (int j = 1; j < array.length; j++) {
                    if ((array[0] ^ array[j]) == 0) {
                        count++;
                    }
                }
            }
            if (i != 0) {
                int tmp = array[0];
                array[0] = array[i];
                array[i] = tmp;

                for (int j = 1; j < array.length; j++) {
                    if ((array[0] ^ array[j]) == 0) {
                        count++;
                    }
                }
            }
            if(count > (array.length/2)-1) {
                System.out.println(array[0]+"就是那个多数元素");
            }
        }

        int ret2 = findMoreNum2(array);
        System.out.println(ret2);
    }
    public static int findMoreNum1(int[] array) {
    Arrays.sort(array);
    return array[array.length/2];
    }
    public static int findMoreNum2(int[] array) {
        int count = 0;
        int tmp = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] == tmp) {
            count++;
            }else if(array[i] != tmp) {
                count--;
            }

            if (count == 0) {
                tmp = array[i];
            }
        }
        return tmp;
    }
    public static void main5(String[] args) {
        //给定一个非空整数数组，除了某个元素只出现一次以外
        // 其余每个元素均出现两次。找出那个只出现了一次的元素。
        int[] array = {2,2,1,5,1};
        int count = 0;
        for (int i = 0; i < array.length; i++) {

            if(i != 0) {
                int tmp = array[0];
                array[0] = array[i];
                array[i] = tmp;
            }

            for (int j = 1; j < array.length; j++) {
                if((array[0] ^ array[j]) != 0) {
                    count++;
                }
            }

            if(count == array.length-1) {
                if(i == 0) {
                    System.out.println(0+"就是那个单独的数的下标！");
                    break;
                }else {
                    System.out.println(i+"就是那个单独的数的下标！");
                    break;
                }
            }

            count = 0;

        }
       // findNum(array);

    }
    public static void findNum(int[] array){
        int ret = array[0];
        for (int i = 1; i < array.length; i++) {
            ret ^= array[i];
        }
        System.out.println(ret);
    }

    public static void main4(String[] args) {
        //给定一个整型数组, 实现冒泡排序(升序排序)
        int[] array = {1,5,8,2,15,30};
        bubbleSort1(array);
        System.out.println(Arrays.toString(array));
        bubbleSort2(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSort1(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = 0;
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
    public static void bubbleSort2(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            boolean flg = false;
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = 0;
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false) {
                return;
            }
        }
    }

    public static void main3(String[] args) {
        //给定一个有序整型数组, 实现二分查找
        int[] array = {1,2,3,4,5,6};
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        Arrays.sort(array);
        System.out.println(binarySearch2(array, x));
    }

    public static int binarySearch2(int[] array,int x ) {
        int left = 0;
        int right = array.length-1;
        int mid = 0;
        while (left <= right) {
            mid = (left+right)/2;
            if(x > array[mid]) {
                left = mid + 1;
            }else if(x < array[mid]) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static void main2(String[] args) {
        //调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
        //
        //如数组：[1,2,3,4,5,6]
        //
        //调整后可能是：[1, 5, 3, 4, 2, 6]
        int[] array1 = {1,2,3,4,5,6,7};
        trans1(array1);
        System.out.println(Arrays.toString(array1));
        trans1(array1);
        System.out.println(Arrays.toString(array1));
    }
    public static void trans1(int[] array1) {
        int left = 0;
        int right = array1.length-1;
        while (left <= right) {

            if(array1[left]%2==0&&array1[right]%2!=0) {
                int tmp = 0;
                tmp = array1[left];
                array1[left] = array1[right];
                array1[right] = tmp;
            }
            if(array1[left]%2!=0){
                left++;
            }
            if(array1[right]%2==0){
                right--;
            }
        }
    }

    public static void trans2(int[] array) {
        int left = 0;
        int right = array.length;
        while(left < right) {
            while (left < right && array[left] % 2 == 0) {
                left++;
            }
            while (left < right && array[right] % 2 != 0) {
                right--;
            }
            int tmp = 0;
            tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
    }

    public static void main1(String[] args) {
        //实现一个方法 transform, 以数组为参数,
        // 循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上.
        // 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
        int[] array1 = {1,2,3};
        int[] array2 = transform(array1);
        System.out.println(Arrays.toString(array2));
    }
    public static int [] transform(int[] array1) {
        int[] array2 = new int[array1.length];
        for (int i = 0; i < array1.length; i++)
        {
            array2[i] = array1[i]*2;
        }
        return array2;
    }

}
