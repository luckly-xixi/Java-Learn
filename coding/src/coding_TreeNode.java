import java.util.*;
import java.util.logging.Level;

public class coding_TreeNode {


    class Node {
        int value;
        Node left;
        Node right;
        Node(int val) {
            value = val;
        }
    }


//二叉树的最大宽度
    public static int getWidthLevel1(Node head) {
        if(head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node,Integer> levelMap = new HashMap<>();
        levelMap.put(head,1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if(curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max,curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            if(cur.left != null) {
                levelMap.put(cur.left,curLevel+1);
                queue.add(cur.left);
            }
            if(cur.right != null) {
                levelMap.put(cur.right,curLevel+1);
                queue.add(cur.right);
            }
        }
        return max;
    }

//    public static int getWidthLevel2(Node head) {
//        if(head == null) {
//            return 0;
//        }
//        Queue<Node> queue = new LinkedList<Node>();
//        Node curEnd = head;
//        Node nextNode = null;
//        int max = Integer.MIN_VALUE;
//        int curLevelNode = 0;
//
//        while(!queue.isEmpty()) {
//            Node cur = queue.poll();
//            if(cur.left != null) {
//                nextNode = cur.left;
//                queue.add(cur.left);
//            }
//            if(cur.right != null) {
//                nextNode = cur.right;
//                queue.add(cur.right);
//            }
//        }
//        return max;
//    }


//判断二叉搜索树（只要左树比当前节点的数值大，则不满足）

    public static int preValue = Integer.MIN_VALUE;

    public static boolean checkBST1(Node head) {
        if(head == null) {
            return true;
        }
        boolean isLeftBst = checkBST1(head.left);


        if(!isLeftBst) {
            return false;
        }

        if(head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }

        return checkBST1(head.right);
    }




    //递归方式
    public static boolean checkBST2(Node head) {
        List<Node> inOrderList = new ArrayList<Node>();
        process2(head,inOrderList);
        for(int i=1; i<inOrderList.size(); i++) {
            if(inOrderList.get(i).value < inOrderList.get(i-1).value) {
                return false;
            }
        }
        return true;
    }
    public static void process2(Node head,List<Node> inOrderList) {
        if(head == null) {
            return;
        }
        process2(head.left,inOrderList);
        inOrderList.add(head);
        process2(head.right,inOrderList);
    }



    //中序遍历（非递归）
    public static boolean checkBST3(Node head) {
        if(head != null) {
            int preValue = Integer.MIN_VALUE;
            Stack<Node> stack = new Stack<Node>();
            while(!stack.isEmpty() || head != null) {
                if(head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();


                    if(head.value <= preValue) {
                        return false;
                    } else {
                        preValue = head.value;
                    }

                    head = head.right;
                }
            }
        }
        return true;
    }

    //判断二叉搜索树（树形DP）动态规划
public static class ReturnData {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean is, int mi, int ma) {
            isBST = is;
            min = mi;
            max = ma;
        }
}

    public static ReturnData process3(Node x) {
        if(x == null) {
            return null;
        }

        ReturnData leftData = process3(x.left);
        ReturnData rightData = process3(x.right);

        int min = x.value;
        int max = x.value;
        if(leftData != null) {
            min = Math.min(min,leftData.min);
            max = Math.min(max,leftData.max);
        }
        if(rightData != null) {
            min = Math.min(min,rightData.min);
            max = Math.min(max,rightData.max);
        }

//        boolean isBST = true;
//        if(leftData!=null && (!leftData.isBST || leftData.max >= x.value)) {
//            isBST = false;
//        }
//        if(rightData!=null && (!rightData.isBST || leftData.min <= x.value)) {
//            isBST = false;
//        }

        boolean isBST = false;
        if(((leftData != null ? (leftData.isBST && leftData.max < x.value) : true))
                && ((rightData != null ? (rightData.isBST && rightData.min > x.value) : true))) {
            isBST = true;
        }

        return new ReturnData(isBST,min,max);
    }



//判断完全二叉树(1、任意节点有右无左false  2、在1不违规的情况下，如果遇到了第一个左右孩子不全的后续都是叶子节点)
    public static boolean isCBT(Node head) {
        if(head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);

        boolean leaf = false;        //是否遇见过左右两个孩子不双全的节点

        Node l = null;
        Node r = null;

        while(!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;

            //  如果遇见了不双全的结点之后，又发现当前节点不是叶子节点
            if((leaf && (l != null || r != null)
                || (l == null && r != null ))) {
                return false;
            }

            if(l != null) {
                queue.add(l);
            }
            if(r != null) {
                queue.add(r);
            }

            if(l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }




//判断是否是平衡二叉树

    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isB,int hei) {
            isBalanced = isB;
            height = hei;
        }
    }

    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static ReturnType process(Node x) {
        if(x == null) {
            return new ReturnType(true,0);
        }

        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);

        int height = Math.max(leftData.height,rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;

        return new ReturnType(isBalanced,height);
    }


//判断满二叉树

public static class Info {
        public int height;
        public int nodes;

        public Info(int h,int n) {
            height = h;
            nodes = n;
        }
}


    public static boolean isFull(Node head) {
        if(head == null) {
            return  true;
        }

        Info data = process4(head);
        return data.nodes == (1 << data.height - 1);
    }


    public static Info process4(Node x) {
        if(x == null) {
            return new Info(0,0);
        }

        Info leftData = process4(x.left);
        Info rightData = process4(x.right);

        int height = (leftData.height + rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;

        return new Info(height,nodes);
    }

//o1和o2一定属于head为头的树，返回o1和o2的最低公共祖先
    public static Node lowestCommonAncestor1(Node head,Node o1,Node o2) {
        HashMap<Node,Node> fatherMap = new HashMap<>();
        fatherMap.put(head,head); //头节点
        process5(head,fatherMap);

        HashSet<Node> set1 = new HashSet<Node>();

        Node cur = o1;
        while(cur != fatherMap.get(cur)) { // 不是头节点
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);

        cur = o2;
        while (true) {
            if(set1.contains(cur)) {
               break;
            }
            cur = fatherMap.get(cur);
        }
        return cur;
    }

    public static void process5(Node head,HashMap<Node,Node> fatherMap) {
        if(head == null) {
            return;
        }

        fatherMap.put(head.left,head);
        fatherMap.put(head.right,head);

        process5(head.left,fatherMap);
        process5(head.right,fatherMap);
    }


    //上述优化方案
    public static Node lowestCommonAncestor2(Node head,Node o1,Node o2) {
       if(head == null || head == o1 || head == o2) {
           return head;
       }

       Node left = lowestCommonAncestor2(head.left,o1,o2);
       Node right = lowestCommonAncestor2(head.right,o1,o2);
       if(left != null && right != null) {
           return head;
       }

       return left != null ? left : right;
    }



//中序遍历的后续节点
    public static Node getSuccessorNode(Node node) {
        if(node == null) {
            return node;
        }
        if(node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = (node);
            while(parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
    public static Node getLeftMost(Node node) {
        if(node == null) {
            return node;
        }
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}
