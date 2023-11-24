import java.util.List;
import java.util.Stack;

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

}
