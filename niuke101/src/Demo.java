import java.util.*;

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

    }
