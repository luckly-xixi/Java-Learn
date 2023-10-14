import com.sun.javafx.geom.Edge;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.sql.Timestamp;
import java.util.*;


public class graph {


    public static class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    public static class Node {
        public int value;
        public int in;
        public int out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    public static class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }


//图的构建
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) { // 按行遍历
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }


//图的宽度优先遍历(使用set保证不被环给困住)  是在数据出队列的时候处理
    public static void bfs(Node node) {
        if(node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        HashSet<Node> set = new HashSet<Node>();
        queue.add(node);
        set.add(node);

        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            System.out.println(cur.value); //可替换为具体的处理逻辑

            for(Node next : cur.nexts) {
                if(!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }


//图的深度优先遍历（使用set保证不被环给困住)  是在数据入栈的时候处理
    public static void dfs(Node node) {
        if(node == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        HashSet<Node> set = new HashSet<Node>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);

        while(!stack.isEmpty()) {
            Node cur = stack.pop();

            for(Node next : cur.nexts) {

                if(!set.contains(next)) {
                    stack.push(node);
                    stack.push(next);
                    set.add(next);

                    System.out.println(next.value); // 可替换的处理逻辑

                    break;
                }

            }
        }
    }


//拓扑排序（有向图）
    public static List<Node>  sortedTopology(Graph graph) {
        //Key:某一个node    Value:剩余的入度
        HashMap<Node,Integer> inMap = new HashMap<Node,Integer>();
        //只有入度为0的点，才能进入队列
        Queue<Node> zeroInQueue = new LinkedList<Node>();

        for(Node node : graph.nodes.values()) {
            inMap.put(node,node.in);
            if(node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        //拓扑排序结果，依次加入result
        List<Node> result = new ArrayList<Node>();
        while(!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);

            for(Node next : cur.nexts) {
                inMap.put(next,inMap.get(next) - 1);
                if(inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }

//生成最小生成树

//K算法（要求无向图）
    public static class MySets{
        public HashMap<Node,List<Node>> setMap;

        public MySets(List<Node> nodes) {
            for(Node cur : nodes) {
                List<Node> set = new ArrayList<Node>();
                set.add(cur);
                setMap.put(cur,set);
            }
        }

        public boolean isSameSet(Node from,Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> tomSet = setMap.get(to);
            return fromSet == tomSet;
        }

        public void union(Node from,Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);

            for(Node toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode,fromSet);
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskalMST(Graph graph) {
        MySets init = new MySets((List<Node>) graph.nodes); //初始化把图中每个节点搞成单个链表
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for(Edge edge : graph.edges) { //M条边
            priorityQueue.add(edge); //由小到大排序边
        }
        Set<Edge> result = new HashSet<>();
        while(!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if(!init.isSameSet(edge.from,edge.to)) {
                result.add(edge);
                init.union(edge.from,edge.to);
            }
        }
        return result;
    }



//K算法（要求无向图）不规定出发点

    public static Set<Edge> primMST(Graph graph) {
        //解锁的边进入小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());

        HashSet<Node> set = new HashSet<>();

        Set<Edge> result = new HashSet<>();

        for(Node node : graph.nodes.values()) { // 处理森林问题

            if(!set.contains(node)) { //压入新节点
                set.add(node);
                for(Edge edge : node.edges) { // 判断新节点的各条边
                    priorityQueue.add(edge);
                }
                while(!priorityQueue.isEmpty()) { // 新的边的指向
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if(!set.contains(toNode)) { // 如果是新的边
                        set.add(toNode); // 注册
                        result.add(edge); // 拉入
                        for(Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }



//Dijkstra算法（适合范围：可以有权值为负数的边，但是不可以有累加值为负数的环）单元最小路径算法

    public static HashMap<Node,Integer> dijkstra1(Node head) {
        //从head出发到所有点的最小距离
        //Key：从head出发到达Key
        //Value：从head出发到达Key的最小距离
        //如果表中没有T的记录，含义是从head出发到达T这个点的距离为正无穷大
        HashMap<Node,Integer> distanceMap = new HashMap<>();
        distanceMap.put(head,0);
        //已经求过距离的节点，存在selectedNode中，锁定
        HashSet<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);

        while(minNode != null) {
            int distance = distanceMap.get(minNode);
            for(Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode,distance + edge.weight);
                } else {
                    distanceMap.put(edge.to,Math.min(distanceMap.get(toNode),distance + edge.weight));
                }
                selectedNodes.add(minNode);
                minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
            }
        }
        return distanceMap;
    }


    public static Node getMinDistanceAndUnselectedNode(
            HashMap<Node,Integer> distanceMap,
            HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for(Map.Entry<Node,Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if(!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }














    public static class NodeRecord {
        public Node node;
        public int distance;

        public NodeRecord(Node node,int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap {
        private Node[] nodes;
        private HashMap<Node,Integer> heapIndexMap; // node 在堆上的位置
        private HashMap<Node,Integer> distanceMap;
        private int size;

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private boolean isEntered(Node node) {//  node是否进入过堆
            return heapIndexMap.containsKey(node);
        }

        private boolean inHeap(Node node) { // node 是否在堆上
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        private void swap(int index1,int index2) {
            heapIndexMap.put(nodes[index1],index2);
            heapIndexMap.put(nodes[index2],index1);
            Node temp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = temp;
        }
    }

// 改进后的dijkstra算法
    public static HashMap<Node,Integer> dijkstra2(Node head,int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head,0);
        HashMap<Node,Integer> result = new HashMap<>();
        while(!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.ditance;
            for(Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to,edge.weight + distance);
            }
            result.put(cur,distance);
        }
        return result;
    }
}
