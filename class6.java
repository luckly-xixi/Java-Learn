import java.util.Arrays;

public class class6 {

    public static void main(String[] args) {

    }

    public static void main19(String[] args) {
        int[] array1 = {1,2,3,4};
        int[] array2 = {1,2,3,4};

        System.out.println(Arrays.equals(array1,array2));//true
    }

    public static void main18(String[] args) {
        int[] array1 = {1,2,3,4};
        int[] array2 = Arrays.copyOfRange(array1,1,3);//[1,3)

        System.out.println(Arrays.toString(array2));
    }

    public static void main17(String[] args) {
        int[] array = {1,2,3,4};
        int[] copy = new int[array.length+1];

        System.arraycopy(array,0,copy,1,array.length);
        //拷贝arry数组到copy数组，把array数组的所有元素，从copy数组
        //第二个元素开始往后放
        System.out.println(Arrays.toString(copy));
        //[0, 1, 2, 3, 4]
    }


    public static void main16(String[] args) {
        //拷贝方式二：
        int[] array = {1,2,3,4};
        int[] newArr = Arrays.copyOf(array,array.length*2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(newArr));

        System.out.println("==========");

        newArr[0] = 199;
        System.out.println(Arrays.toString(array));//[1, 2, 3, 4]
        System.out.println(Arrays.toString(newArr));//[99, 2, 3, 4]
    }

    public static void main15(String[] args) {
        //拷贝方式一：
        int[] array = {1,2,3,4};

        int[] newArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(newArr));

        System.out.println("==========");

        newArr[0] = 99;
        System.out.println(Arrays.toString(array));//[1, 2, 3, 4]
        System.out.println(Arrays.toString(newArr));//[99, 2, 3, 4]
    }

    public static void main14(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(Arrays.toString(array));
        int[] array2 = array;
        System.out.println(Arrays.toString(array2));
        //上面的代码不叫拷贝，因为对象始终还是一个
    }

    public static void main13(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        System.out.println(myToString(array));
        System.out.println(myToString(null));
    }
    public static String myToString(int[] array) {
        //判断一下如果传过来的如果是一个null该怎么处理
        if(array == null) {
            return "null";
        }

        //这里是吧让字符串变量ret开头里面是一个“[”
         String ret = "[";

        for (int i = 0; i < array.length; i++) {
            //便遍历数组同时把数组的数值取出赋值给ret
            ret += array[i];
            if(i != array.length-1) {
                //让ret变量在每次拿到数字后面跟一个逗号，除了最后一个数字
                ret += ",";
            }
        }
        //这里是让ret拼接上一个"]"符号
        ret = ret + "]";

        return ret;
    }

    public static void main12(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        int[] ret = grow3(array);
        System.out.println(Arrays.toString(ret));
        System.out.println(Arrays.toString(array));
    }

    public static void main10(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        int[] ret = grow(array);
        System.out.println(Arrays.toString(ret));
        System.out.println(Arrays.toString(array));
    }
    public static void main11(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        grow2(array);
        //System.out.println(Arrays.toString(ret));
        System.out.println(Arrays.toString(array));
    }
    public static int[] grow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i]*2;
        }
        return array;
    }
    public static int[] grow3(int[] array) {
        int[] tmpArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tmpArr[i] = array[i]*2;
        }
        return tmpArr;
    }
     public static void grow2(int[] array) {
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i]*2;
            }
        }

    public static void main9(String[] args) {
//        int[] array1 = {1,2,3,4};
        int[] array = func3();
        System.out.println(Arrays.toString(array));
    }
    public static int[] func3() {
        int[] tmpArr = {10,11,12};
        return tmpArr;
    }
    public static void main8(String[] args) {
        int[] array1 = {1,2,3,4};
        //func1(array1);//[1, 2, 3, 4]
        func2(array1);//[999, 2, 3, 4]
        System.out.println(Arrays.toString(array1));
    }
    public static void func1(int[] array){
        array = new int[]{15,16,17};
    }
    public static void func2(int[] array){
        array[0] = 999;
    }

    public static void main7(String[] args) {
        int[] array1 = {1,2,3,4};
        int[] array2 = {11,22,33,44};

        array1 = array2;
        array1[0] = 1888;

        System.out.println(Arrays.toString(array1));//[1888, 22, 33, 44]
        System.out.println(Arrays.toString(array2));//[1888, 22, 33, 44]
    }

    public static void main6(String[] args) {
        int[] array1 = {1,2,3,4};
        array1[0] = 99;

        int[] array2 = array1;
        array2[0] = 100;

        System.out.println(Arrays.toString(array1));//[100, 2, 3, 4]
        System.out.println(Arrays.toString(array2));//[100, 2, 3, 4]
    }

    public static void main5(String[] args) {
        int[] array = null;

        //System.out.println(array);
        //会抛出空指针异常，原因：使用了一个值为null的引用
        int a = 0 ;
        System.out.println(a);
    }

    public static void main4(String[] args) {
        int[] array = {12,22,31,4,5};
        for (int x:array) {
            System.out.println(array[x]);
        }

    }

    public static void main3(String[] args) {
        int[] array = {12,22,31,4,5};
        //Arrays.sort(array)
        //是将数组里面元素从大到小排序
        Arrays.sort(array);
        String ret = Arrays.toString(array);
        System.out.println(ret);
    }


    public static void main2(String[] args) {
        int[] array= new int[]{1,2,3,4};

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        for (int x:array){
            System.out.println(x);
        }
        for (int z:array){
            System.out.println(z);
        }
        for (int y:array){
            System.out.println(y);
        }

        System.out.println(array.length);
        //Arrays.toString(array)
        //但是他有一个String类型的返回值
        //将数组里面的元素以字符串的形式输出
        String ret = Arrays.toString(array);
        System.out.println(ret);
    }

    public static void main1(String[] args) {

        int[] array = {1,2,3,4,5};
        int[] array2 = new int[]{1,2,3,4,5};
        int[] array3 = new int[6];

        int[] array4;
        array4 = new int[] {1,2,3,4,5};
    }

}
