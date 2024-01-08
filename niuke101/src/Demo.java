import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import javax.xml.soap.SAAJResult;
import java.util.*;
import java.util.concurrent.CountDownLatch;


class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}

public class Demo {

    // 1. 反转链表
    // 链表实现
    public ListNode ReverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 栈实现
    public ListNode ReverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        if (stack.isEmpty()) {
            return null;
        }

        ListNode node = stack.pop();
        ListNode dummy = node;

        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            node.next = tmp;
            node = node.next;
        }
        node.next = null;
        return dummy;
    }

    // 尾递归实现
    public ListNode ReverseList3(ListNode head) {
        return reversetListInt(head, null);
    }

    private ListNode reversetListInt(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }

        ListNode next = head.next;
        head.next = newHead;
        ListNode node = reversetListInt(next, head);
        return null;
    }

    // 2. 链表指定区间反转
    // 区间内多次交换
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < n - m + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseLinkedList(leftNode);

        pre.next = rightNode;
        leftNode.next = cur;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
    }

    // 单次遍历直接交换
    public ListNode reverseBetween2(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode Cur_next;
        for (int i = 0; i < n - m; i++) {
            Cur_next = cur.next;
            cur.next = Cur_next.next;
            Cur_next.next = pre.next;
            pre.next = Cur_next;
        }

        return dummy.next;
    }


    // 3.链表中每K个为一组反转
    // 递归
    public ListNode reverseKGroup1 (ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if(tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode pre = null;
        ListNode cur = head;
        while(cur != tail) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        head.next = reverseKGroup1(tail, k);
        return pre;
    }

    // 非递归
    public ListNode reverseKGroup2 (ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while(end.next != null) {
            for(int i=0; i<k && end!=null; i++) {
                end = end.next;
            }
            if(end == null) {
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;
            pre.next = reverse(start);

            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 4. 合并两个排序的链表
    public ListNode Merge1 (ListNode pHead1, ListNode pHead2) {

        if(pHead1 == null || pHead2 == null) {
            return pHead1 == null ? pHead2 : pHead1;
        }

        if(pHead1.val <= pHead2.val) {
            pHead1.next = Merge1(pHead1.next, pHead2);
            return  pHead1;
        } else {
            pHead2.next = Merge1(pHead1, pHead2.next);
            return pHead2;
        }
    }

    // 5.合并k个已排序的链表
    // 归并排序

    private ListNode Merge2(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if(list1 != null) {
            cur.next = list1;
        }
        if(list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }

    private ListNode divideMerge(ArrayList<ListNode> lists, int left, int right) {
        if(left > right) {
            return null;
        }
        if(left == right) {
            return lists.get(left);
        }

        int mid = (left + right) / 2;
        return Merge2(divideMerge(lists, left, mid), divideMerge(lists,mid+1, right));
    }


    public ListNode mergeKLists1(ArrayList<ListNode> lists) {
        return divideMerge(lists, 0, lists.size()-1);
    }

    // 优先级队列
    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);

        for(int i=0; i<lists.size(); i++) {
            if(lists.get(i) != null) {
                pq.add(lists.get(i));
            }
        }

        ListNode res = new ListNode(0);
        ListNode head = res;

        while(!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            head.next = tmp;
            head = head.next;

            if(tmp.next != null) {
                pq.add(tmp.next);
            }
        }
    return res.next;
    }

    // 6. 判断链表中是否有环
    // 快慢指针
    public boolean hasCycle1(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    // 集合
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while(head != null) {
            if(set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;
    }

    // 逐个删除
    public boolean hasCycle3(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        if(head.next == head) {
            return true;
        }

        ListNode nextNode = head.next;
        head.next = head;
        return hasCycle3(nextNode);
    }


    // 7.链表中环的入口结点
    // 快慢指针

    private ListNode hasCycle(ListNode pHead) {
        if(pHead == null) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return slow;
            }
        }
            return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = hasCycle(pHead);

        if(slow == null) {
            return null;
        }

        ListNode fast = pHead;

        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 8. 链表中倒数最后k个结点
    // 快慢指针
    public ListNode FindKthToTail1 (ListNode pHead, int k) {

        ListNode fast = pHead;
        for (int i = 0; i < k; i++) {
            if(fast == null) {
                return null;
            }
            else {
                fast = fast.next;
            }
        }

        ListNode slow = pHead;
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 栈实现
    public ListNode FindKthToTail2 (ListNode pHead, int k) {
        Stack<ListNode> stack = new Stack<>();
        int count = 0;
        while(pHead != null) {
            stack.push(pHead);
            pHead = pHead.next;
            count++;
        }

        if(count <k || k == 0) {
            return null;
        }

        ListNode firstNode = stack.pop();
        while (--k > 0) {
            ListNode tmp = stack.pop();
            tmp.next = firstNode;
            firstNode = tmp;
        }

        return firstNode;
    }

    // 递归实现
    int size;
    public ListNode FindKthToTail3 (ListNode pHead, int k) {
        if(pHead == null) {
            return null;
        }

        ListNode node = FindKthToTail3(pHead.next, k);
        ++size;

        if(size < k) {
            return null;
        } else if(size == k) {
            return pHead;
        } else {
            return node;
        }

    }


    // 9. 删除链表的倒数第n个节点
    // 双指针
    public ListNode removeNthFromEnd1 (ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode fast = head;
        ListNode pre = res;
        ListNode cur = head;

        while(n != 0) {
            fast = fast.next;
            n--;
        }

        while(fast != null) {
            fast = fast.next;
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;
        return res.next;
    }


    // 长度统计
    public ListNode removeNthFromEnd2 (ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;

        int length = 0;

        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            length++;
        }
        cur = res;

        for(int i=0; i<length-n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return res.next;
    }


    // 递归
    public ListNode removeNthFromEnd (ListNode head, int n) {
        int pos = length(head, n);
        if(pos == n) {
            return head.next;
        }
        return head;
    }

    private int length(ListNode head, int n) {
        if(head == null) {
            return 0;
        }
        int pos = length(head.next, n) + 1;

        if(pos == n+1) {
            head.next = head.next.next;
        }
        return pos;
    }


    // 10. 两个链表的第一个公共结点
    // 双指针
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {

        ListNode l1 = pHead1, l2 = pHead2;
        while(l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;

    }


    // Set
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set = new HashSet<>();

        while(pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }

        while(pHead2 != null) {
            if(set.contains(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

    // 统计长度
    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {

        int lenA = length1(pHead1), lenB = length1(pHead2);

        while(lenA != lenB) {
            if(lenA > lenB) {
                pHead1 = pHead1.next;
                lenA--;
            } else {
                pHead2 = pHead2.next;
                lenB--;
            }
        }

        while(pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return pHead1;
    }

    private int length1(ListNode node) {
        int length = 0;
        while(node != null) {
            node = node.next;
            length++;
        }
        return length;
    }


    // 11.链表相加

    public ListNode addInList (ListNode head1, ListNode head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }

        head1 = ReverseList1(head1);
        head2 = ReverseList1(head2);

        ListNode res = new ListNode(-1);
        ListNode head = res;

        int carry = 0;

        while(head1 != null || head2 != null || carry != 0) {
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;

            int tmp = val1 + val2 + carry;
            carry = tmp / 10;
            tmp %= 10;

            head.next = new ListNode(tmp);
            head = head.next;

            if(head1 != null) {
                head1 = head1.next;
            }
            if(head2 != null) {
                head2 = head2.next;
            }
        }

        return ReverseList1(res.next);
    }



    // 12. 单链表的排序
    public ListNode sortInList (ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortInList(head);
        ListNode right = sortInList(tmp);

        ListNode h = new ListNode(0);
        ListNode res = h;

        while(left != null && right != null) {
            if(left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }

        h.next = left != null ? left : right;
        return res.next;
    }


    // 13. 判断一个链表是否为回文结构
    // 反转对比
    public boolean isPail1 (ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        while(head != null) {
            nums.add(head.val);
            head = head.next;
        }

        ArrayList<Integer> tmp = new ArrayList<>();
        tmp = (ArrayList<Integer>) nums.clone();

        Collections.reverse(tmp);

        for(int i=0; i<nums.size(); i++) {
            int x = nums.get(i);
            int y = tmp.get(i);
            if(x != y) {
                return false;
            }
        }
        return true;
    }

    // 对撞指针
    public boolean isPail2 (ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        while(head != null) {
            nums.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = nums.size() - 1;

        while(left <= right) {
            int x = nums.get(left);
            int y = nums.get(right);
            if(x != y) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 双指针找中点
    public boolean isPail3 (ListNode head) {
        if(head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while(slow != null) {
            if(slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }


    // 14. 链表的奇偶重排

    public ListNode oddEvenList (ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode even = head.next;
        ListNode odd = head;

        ListNode evenhead = even;

        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }


    // 15.  删除有序链表中重复的元素 - Ⅰ

    public ListNode deleteDuplicates1 (ListNode head) {
        if(head == null ) {
            return null;
        }

        ListNode cur = head;

        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }



    // 16. 删除有序链表中重复的元素 - Ⅱ
    // 正常遍历跳过
    public ListNode deleteDuplicates2 (ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode res = new ListNode(0);
        res.next = head;

        ListNode cur = res;

        while(cur.next != null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val) {
                int tmp = cur.next.val;
                while(cur.next != null && cur.next.val == tmp){
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return res.next;
    }

    // 哈希表
    public ListNode deleteDuplicates3 (ListNode head) {
        if(head == null) {
            return null;
        }

        Map<Integer, Integer> mp = new HashMap<>();
        ListNode cur = head;

        while(cur != null) {
            if(mp.containsKey(cur.val)) {
                mp.put(cur.val, (int)mp.get(cur.val) + 1);
            } else {
                mp.put(cur.val, 1);
            }
            cur = cur.next;
        }

        ListNode res = new ListNode(0);
        res.next = head;
        cur = res;

        while(cur.next != null) {
            if(mp.get(cur.next.val) != 1) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return res.next;
    }


    // 17. 二分查找
    public int search (int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    // 18. 二维数组中的查找

    public boolean Find (int target, int[][] array) {
        if(array.length == 0) {
            return false;
        }

        int n = array.length;
        if(array[0].length == 0) {
            return false;
        }
        int m = array[0].length;

        for(int i=n-1, j=0; i>=0 && j<m; ) {
            if(array[i][j] > target) {
                i--;
            } else if(array[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }


    // 19. 寻找峰值
    public int findPeakElement (int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] > nums[mid+1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


    // 20. 数组中的逆序对
    public int mod = 1000000007;

    private int mergeSort(int left, int right, int[] data, int[] tmp) {
        if(left >= right) {
            return 0;
        }
        int mid = (left + right) / 2; // ((right - left) >> 2) + left;

        int res = mergeSort(left, mid, data, tmp) + mergeSort(mid+1, right, data, tmp);
        res %= mod;

        int i = left, j = mid + 1;
        for(int k=left; k<=right; k++) {
            tmp[k] = data[k];
        }

        for(int k=left; k<=right; k++) {
            if(i == mid+1) { /*左边走完*/
                data[k] = tmp[j++];
            } else if(j == right +1 /*右边走完*/ || tmp[i] <= tmp[j]) {
                data[k] = tmp[i++];
            } else { // tmp[i] > tmp[j]
                data[k] = tmp[j++];
                res += mid - i + 1;
            }
        }
        return res % mod;
    }

    public int InversePairs (int[] nums) {
         int n = nums.length;
         int[] res = new int[n];
         return mergeSort(0, n-1, nums, res);
    }

    // 21. 旋转数组的最小数字

    public int minNumberInRotateArray (int[] nums) {

        if(nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            int mid = ((right - left) >> 2) + left;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    // 22. 比较版本号
    // 双指针
    public int compare1 (String version1, String version2) {
        int n1 = version1.length();
        int n2 = version2.length();

        int i = 0, j = 0;
        while(i<n1 || j<n2) {
            long num1 = 0;
            while(i<n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }
            i++;

            long num2 = 0;
            while(j<n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }
            j++;

            if(num1 < num2) {
                return -1;
            }
            if(num1 > num2) {
                return 1;
            }
        }
        return 0;
    }

    // 分割
    public int compare (String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        for(int i=0; i<nums1.length || i<nums2.length; i++) {
            String str1 = i < nums1.length ? nums1[i] : "0";
            String str2 = i < nums2.length ? nums2[i] : "0";

            long num1 = 0;
            for(int j=0; j<str1.length(); j++) {
                num1 = num1 * 10 + (str1.charAt(j) - '0');
            }

            long num2 = 0;
            for(int j=0; j<str2.length(); j++) {
                num2 = num2 * 10 + (str2.charAt(j) - '0');
            }

            if(num1 > num2) {
                return 1;
            }
            if(num1 < num2) {
                return -1;
            }
        }
        return 0;
    }


    // 23. 画出流程图、给出完整的程序代码、截图说明程序功能的实现结果。
    class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
          this.val = val;
        }

    }

    // 递归
    private void preoder(List<Integer> list, TreeNode root) {
        if(root == null) {
            return;
        }

        list.add(root.val);

        preoder(list, root.left);
        preoder(list, root.right);
    }

    public int[] preorderTraversal1 (TreeNode root) {
        List<Integer> list = new ArrayList<>();

        preoder(list, root);

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    // 非递归(栈)

    public int[] preorderTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return new int[0];
        }

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }

        int[] res = new int[list.size()];

        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    // 24. 二叉树的中序遍历
    // 递归

    private void inorder(List<Integer> list, TreeNode root) {
        if(root == null) {
            return;
        }

        inorder(list, root.left);

        list.add(root.val);

        inorder(list, root.right);
    }


    public int[] inorderTraversal1 (TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorder(list, root);

        int[] res = new int[list.size()];

        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    // 非递归（栈）
    public int[] inorderTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return new int[0];
        }

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            root = root.right;
        }

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    // 25. 二叉树的后序遍历
    // 递归

    private void postorder(List<Integer> list, TreeNode root) {
        if(root == null) {
            return;
        }

        postorder(list, root.left);
        postorder(list, root.right);

        list.add(root.val);
    }


    public int[] postorderTraversal1 (TreeNode root) {
        List<Integer> list = new ArrayList<>();

        postorder(list, root);

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // 非递归（栈）
    public int[] postorderTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();

            if(node.right == null || node.right == pre) {
                list.add(node.val);
                pre = node;
            } else {
                stack.push(node);
                root = node.right;
            }
        }

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    // 26. 层序遍历
    // 非递归(双端队列)
    public ArrayList<ArrayList<Integer>> levelOrder1 (TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<>();
            int n = queue.size();

            for(int i=0; i<n; i++) {
                TreeNode cur = queue.poll();
                row.add(cur.val);

                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(row);
        }
        return res;
    }



    // 递归

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    private void traverse(TreeNode root, int depth) {

        if(root != null) {

            if(res.size() < depth) {
                ArrayList<Integer> row =  new ArrayList<>();
                res.add(row);
                row.add(root.val);
            } else {
                ArrayList<Integer> row = res.get(depth - 1);
                row.add(root.val);
            }

        } else {
            return;
        }

        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if(root == null) {
            return res;
        }

        traverse(root, 1);

        return res;
    }


    // 27. 按之字形顺序打印二叉树

    // 队列
    public ArrayList<ArrayList<Integer>> Print1 (TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        TreeNode head = pRoot;
        if(head == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        TreeNode p;

        boolean flag = true;

        while(!queue.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<>();
            int n = queue.size();
            flag = !flag;

            for (int i = 0; i < n; i++) {

                p = queue.poll();
                row.add(p.val);

                if(p.left != null) {
                    queue.add(p.left);
                }
                if(p.right != null) {
                    queue.add(p.right);
                }
            }
            if(flag) {
                Collections.reverse(row);
            }
            res.add(row);
        }
        return res;
    }


    // 双栈
    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        TreeNode head = pRoot;
        if(head == null) {
            return res;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);

        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();

            while(!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                tmp.add(node.val);
                if(node.left != null) {
                    stack2.push(node.left);
                }
                if(node.right != null) {
                    stack2.push(node.right);
                }
            }

            if(tmp.size() != 0) {
                res.add(new ArrayList<Integer>(tmp));
            }
            tmp.clear();

            while(!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                tmp.add(node.val);
                if(node.right != null) {
                    stack1.push(node.right);
                }
                if(node.left != null) {
                    stack1.push(node.left);
                }
            }

            if(tmp.size() != 0) {
                res.add(new ArrayList<Integer>(tmp));
            }
            tmp.clear();
        }
        return res;
    }



    // 28. 二叉树的最大深度
    // 递归
    public int maxDepth1 (TreeNode root) {
        if(root == null) {
            return 0;
        }

        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    // BFS
    public int maxDepth2 (TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int res = 0;

        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0; i<n; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            res++;
        }
        return res;
    }


    // DFS
    public int maxDepth (TreeNode root) {
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root);
        level.push(1);

        int max = 0;

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int tmp = level.pop();
            max = Math.max(tmp, max);

            if(node.left != null) {
                stack.push(node.left);
                level.push(tmp + 1);
            }
            if(node.right != null) {
                stack.push(node.right);
                level.push(tmp + 1);
            }
        }
        return max;
    }


    // 29. 二叉树中和为某一值的路径(一)
    // 递归
    public boolean hasPathSum1 (TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }


    // dfs
    public boolean hasPathSum2 (TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(root);
        s2.push(root.val);

        while(!s1.isEmpty()) {
            TreeNode node = s1.pop();
            int cur_sum = s2.pop();

            if(node.left == null && node.right == null && sum == cur_sum) {
                return true;
            }

            if(node.left != null) {
                s1.push(node.left);
                s2.push(cur_sum + node.left.val);
            }
            if(node.right != null) {
                s1.push(node.right);
                s2.push(cur_sum + node.right.val);
            }
        }

        return false;
    }

    // Dfs
    public boolean hasPathSum (TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        root.val = sum - root.val;
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node.left == null && node.right == null && node.val == 0) {
                return true;
            }

            if(node.left != null) {
                node.left.val = node.val - node.left.val;
                queue.add(node.left);
            }
            if(node.right != null) {
                node.right.val = node.val - node.right.val;
                queue.add(node.right);
            }
        }

        return false;
    }


    // 30. 二叉搜索树与双向链表
    // 递归
    public TreeNode head = null;
    public TreeNode pre = null;

    public TreeNode Convert1(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }

        Convert(pRootOfTree.left);

        if(pre == null) {
            head = pRootOfTree;
            pre = pRootOfTree;
        } else {
            pre.right = pRootOfTree;
            pRootOfTree.left = pre;
            pre = pRootOfTree;
        }

        Convert(pRootOfTree.right);
        return head;
    }

    // 非递归
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = null;
        TreeNode pre = null;
        boolean isFirst = true;

        while(pRootOfTree != null || stack.isEmpty()) {

            while(pRootOfTree != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }

            pRootOfTree = stack.pop();
            if(isFirst) {
                head = pRootOfTree;
                pre = head;
                isFirst = false;
            } else {
                pre.right = pRootOfTree;
                pRootOfTree.left = pre;
                pre = pRootOfTree;
            }
            pRootOfTree = pRootOfTree.right;
        }

        return head;
    }


    // 31.对称的二叉树
    //递归

    public boolean recursion(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return recursion(root1.left, root2.right) && recursion(root1.right, root2.left);
    }

    public boolean isSymmetrical1 (TreeNode pRoot) {
        return recursion(pRoot, pRoot);
    }


    // 非递归
    public boolean isSymmetrical (TreeNode pRoot) {
        if(pRoot == null) {
            return true;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(pRoot.left);
        queue2.offer(pRoot.right);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode left = queue1.poll();
            TreeNode right = queue2.poll();

            if(left == null && right == null) {
                continue;
            }

            if(left == null || right == null || left.val != right.val ) {
                return false;
            }

            queue1.offer(left.left);
            queue1.offer(left.right);

            queue2.offer(right.right);
            queue2.offer(right.left);
        }
        return true;
    }


    // 32.合并二叉树
    // 递归
    public TreeNode mergeTrees1 (TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }

        TreeNode head = new TreeNode(t1.val + t2.val);
        head.left = mergeTrees(t1.left, t2.left);
        head.right = mergeTrees(t1.right, t2.right);

        return head;
    }

    // 非递归（队列）
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }

        TreeNode head = new TreeNode(t1.val + t2.val);

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(head);
        queue1.offer(t1);
        queue2.offer(t2);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            TreeNode left1 = node1.left;
            TreeNode left2 = node2.left;

            TreeNode right1 = node1.right;
            TreeNode right2 = node2.right;

            if(left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if(left1 != null) {
                    node.left = left1;
                } else {
                    node.left = left2;
                }
            }

            if(right1 != null || right2 != null) {
                if(right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if(right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }

        return head;
    }


    // 33.二叉树的镜像
    // 递归
    public TreeNode Mirror1 (TreeNode pRoot) {
        if(pRoot == null) {
            return null;
        }

        TreeNode left = Mirror1(pRoot.left);
        TreeNode right = Mirror1(pRoot.right);

        pRoot.left = right;
        pRoot.right = left;

        return pRoot;
    }


    // 非递归(栈)
    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot == null) {
            return  null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return pRoot;
    }


    // 34. 判断是不是二叉搜索树
    // 递归

        int p = Integer.MIN_VALUE;
            public boolean isValidBST1 (TreeNode root){

            if (root == null) {
                return true;
            }

            if (!isValidBST(root.left)) {
                return false;
            }

            if (root.val < p) {
                return false;
            }

            return isValidBST(root.right);
        }

        // 栈
        public boolean isValidBST (TreeNode root){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode head = root;
            ArrayList<Integer> sort = new ArrayList<>();

            while(!stack.isEmpty() || head != null) {
                while(head != null) {
                    stack.push(head);
                    head = head.left;
                }
                head = stack.pop();
                sort.add(head.val);
                head = head.right;
            }

            for(int i=1; i<sort.size(); i++) {
                if(sort.get(i-1) > sort.get(i)) {
                    return false;
                }
            }

            return true;
        }


        // 35. 判断是不是完全二叉树
        // 层序遍历
            public boolean isCompleteTree (TreeNode root) {
                boolean left = true;

                if(root == null) {
                    return true;
                }

                Queue<TreeNode> queue = new LinkedList<>();
                queue.offer(root);

                while(!queue.isEmpty()) {
                    TreeNode nowNode = queue.poll();

                    if(nowNode == null) {
                        left = false;
                    } else {
                        if(left == false) {
                            return false;
                        }
                        queue.offer(nowNode.left);
                        queue.offer(nowNode.right);
                    }

                }

                return true;
            }




        }
