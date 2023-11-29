import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Running_go {
    public static void main(String[] args) {
        Demo demo = new Demo();
//        ArrayList<ListNode> a = new ArrayList<>();
//        ListNode one = new ListNode(1);
//        one.next = new ListNode(2);
//        one.next.next = new ListNode(3);
//
//        ListNode two = new ListNode(4);
//        two.next = new ListNode(5);
//        two.next.next = new ListNode(6);
//
//        ListNode three = new ListNode(7);
//        three.next = new ListNode(8);
//        three.next.next = new ListNode(9);
//
//        a.add(one);
//        a.add(three);
//        a.add(two);
//        ListNode p = demo.mergeKLists2(a);

        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        demo.removeNthFromEnd(head, 2);
    }
}
