import sun.net.idn.Punycode;

public class coding_list {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //将链表划分为<=>三个区域
    public static Node listPartition1(Node head,int pivot) {
        if(head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while(cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for(i=0; i!=nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,pivot);
        for(i=1; i!=nodeArr.length; i++) {
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[i-1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr,int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while(index != big) {
            if(nodeArr[index].value < pivot) {
                swap(nodeArr,++small,index++);
            } else if(nodeArr[index].value == pivot) {
                index++;
            }else {
                swap(nodeArr,--big,index);
            }
        }
    }

    public static void swap(Node[] nodeArr,int a,int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }



    //将链表划分为<=>三个区域(面试)
    public static Node listPartition2(Node head,int pivot) {
        Node sH = null; //small head
        Node sT = null; //small tail
        Node eH = null; //equal head
        Node eT = null; //equal tail
        Node mH = null; //big head
        Node mT = null; //big tail
        Node next = null; //save next node
        while(head != null) {
            next = head.next;
            head.next = null;
            if(head.value < pivot) {
                if(sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if(head.value == pivot) {
                if(eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if(mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
        }

        if(sT != null) {//如果有小于区域
            sT.next = eH;
            eT = eT == null ? sT : eT; //下一步，谁去连接大于区域的头，谁就变成eT
        }
        if(eT != null) {
            eT.next = mH;
        }

        return sH != null ? sH : (eH != null ? eH : mH);
    }




    //调用函数
    public static Node getIntersectNode(Node head1,Node head2) {
        if(head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null) {
            return noLoop(head1,head2);
        }
        if(loop1 != null && loop2 != null) {
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }


    //找到链表第一个入环节点，如果无环返回null
    public static Node getLoopNode(Node head) {
        if(head == null || head.next == null || head.next.next == null) {
            return  null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while(n1 != n2) {
            if(n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while(n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    //两个链表是否有公共部分，是否相交
    public static Node noLoop(Node head1,Node head2) {
        if(head1 == null ||  head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while(cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while(cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2) { // 链表1链表2尾节点不是同一个节点
            return null;
        }
        //n为链表1和链表2节点的个数差值
        cur1 = n > 0 ? head1 : head2; // 谁长，谁的头编变成cur1
        cur2 = cur1 == head1 ? head2 : head1; // 谁短，谁的头变成cur2
        n = Math.abs(n);
        while(n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    //两个有环链表，返回第一个相交节点，如果不相交返回null
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while(cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while(n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while(cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while(cur1 != loop1) {
                if(cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
