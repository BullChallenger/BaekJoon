package Study;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class 너비우선탐색 {

    private static class Node {
        private int data;
        private Node lt;
        private Node rt;

        public Node(int data) {
            this.data = data;
            lt = null;
            rt = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }

    private static void BFS(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node current = queue.poll();
                System.out.print(current.data + " ");
                if (current.lt != null) queue.offer(current.lt);
                if (current.rt != null) queue.offer(current.rt);
            }
            System.out.println();
        }
    }
}
