import javax.xml.soap.Node;
import javax.xml.soap.Text;
import java.util.*;

public class main {


    //有序表所有操作都是O(logN)级别
    public static void main(String[] args) {

        //放在有序表的东西，如果是基础类型的，内部按照值传递，内存占用就是这个东西的大小
        //如果是非基础类型的，必须提供比较器，内部按照引用传递，内存占用是这个东西的内存地址的大小

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);

        TreeMap<Integer,String > treeMap = new TreeMap<>();
        treeMap.put(7,"我是7"); // put 方法既可以新增也可以更新
        treeMap.put(5,"我是5");
        treeMap.put(4,"我是4");
        treeMap.put(3,"我是3");
        treeMap.put(9,"我是9");
        treeMap.put(2,"我是2");
        System.out.println(treeMap.containsKey(5)); //查询操作
        System.out.println(treeMap.get(5)); //根据Key获取Value
        System.out.println(treeMap.firstKey() + "我最小"); //找到表中最小值
        System.out.println(treeMap.lastKey() + "我最大"); //找到表中最大值
        System.out.println(treeMap.floorKey(8) + "在表中所有<=8的数中，我离8最近");
        System.out.println(treeMap.ceilingKey(8) + "在表中所有>=8的数中，我离8最近");
        System.out.println(treeMap.floorKey(7) + "在表中所有<=7的数中，我离8最近");
        System.out.println(treeMap.ceilingKey(7) + "在表中所有>=7的数中，我离8最近");
        treeMap.remove(5); // 移除操作
    }


    //哈希表无论什么数据量CRUD都是常数级别
    public static void main2(String[] args) {
        //哈希表也是无序表

        Node nodeA = null;

        //HashSer不带value
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(3); //增加方法
        System.out.println(hashSet1.contains(3));//查询操作
        hashSet1.remove(3);// 删除操作
        System.out.println(hashSet1.contains(3));



        //HashMap带value,组织方式还是以Key值来组织（比较）
        //放在哈希表的东西，如果是基础类型的，内部按照值传递，内存占用就是这个东西的大小
        //如果是非基础类型的，内部按照引用传递，内存占用是这个东西的内存地址的大小
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"didi"); //增加操作
        hashMap.put(1,"lala"); //更新操作
        hashMap.put(2,"du"); //修改操作

        System.out.println(hashMap.containsKey(1)); // 查询操作   如果没有返回null
        System.out.println(hashMap.get(1)); //通过Key来拿出对应的Value  如果没有返回null

        hashMap.remove(2); // 删除操作
    }

    //排序算法
    public static void main1(String[] args) {
        int[] arr = {2,4,5,1,3,6,8,7,9,0};
        int[] arr2 = {1,3,4,2,5};
//        sort1_selectionSort.selectionSort(arr);
//        sort2_bubbleSort.bubbleSort(arr);
//        sort3_insertSort.insertionSort(arr);
//        sort4_mergSort.process(arr,0,arr.length-1);
//        int a = sort4_mergSort.smallSum(arr2);
//        System.out.println(a);
//        sort5_quickSort.quickSort(arr);
        sort6_heapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
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
