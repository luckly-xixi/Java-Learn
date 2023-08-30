public class one {

    public static void main(String[] args) {









        //1.反转链表
//        给定一个单链表的头结点pHead(该头节点是有值的)，长度为n，反转该链表后，返回新链表的表头。
//        数据范围: 0 <= n <=1000  要求：空间复杂度O(1),时间复杂度O(n).
//        如当输入链表{1,2,3}时,经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。


//        public ListNode ReverseList (ListNode head) {
//            // write code here
//            ListNode pre = null;
//            ListNode cur = head;
//            while(cur!=null){
//                ListNode Cur_next = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = Cur_next;
//            }
//            return pre;



//                // （1）、使用栈
//                Stack<ListNode> stack = new Stack<>();
//                //把链表顺序放入栈中
//                while(head!=null){
//                    stack.push(head);
//                    head = head.next;
//                }
//                //考虑链表为空的情况
//                if(stack.isEmpty())
//                    return null;
//                //创建新链表并且第一个元素放栈顶元素
//                ListNode node = stack.pop();
//                //引用新链表,并且记录头节点
//                ListNode dummy = node;
//                //循环弹出栈顶元素并且放入新链表的下一个节点
//                while(!stack.isEmpty()){
//                    ListNode tempNode = stack.pop();
//                    node.next = tempNode;
//                    node = node.next;
//                }
//                // 新链表最后一个节点置为空，否则会构成环
//                node.next = null;
//                return dummy;



//                //（2）、 双链表
//                // 类似于通过新链表和中间记录变量的链表,完成原链表的按照原来顺序逆置下去
//                //创建一个新链表
//                ListNode newHead = null;
//                while(head != null){
//                    //记录原链表的下一个节点
//                    ListNode temp = head.next;
//                    // 断开原链表的下一个元素的连接
//                    head.next = newHead;
//                    //逆置原链表
//                    newHead = head;
//                    // 访问原链表的下一个元素（在上面已经记录下了）
//                    head = temp;
//                }
//                return newHead;
//

//                //（3）. 递归
//                if(head == null || head.next == null)
//                    // 终止条件
//                    return head;
//                //保存当前节点的下一个节点
//                ListNode next = head.next;
//                //从当前节点的下一个节点开始递归
//                ListNode reverse = ReverseList(next);
//                //reverse是反转之后的链表，因为函数reverseList
//                // 表示的是对链表的反转，所以反转完之后next肯定
//                // 是链表reverse的尾结点，然后我们再把当前节点
//                //head挂到next节点的后面就完成了链表的反转
//                next.next = head;//head.next.next=head;
//                //此时head相当于变成了尾节点，要将其下一个节点置空，防止成环
//                head,next = null;
//                return reverse;


            //（4）. 尾递归
//            return reverseListInt(head,null);
//        }
//
//        private ListNode reverseListInt(ListNode head,ListNode newHead){
//            if(head == null){
//                return newHead;
//            }
//            ListNode next = head.next;
//            head.next = newHead;
//            return reverseListInt(next,head);
//        }
//        }

    }


}
