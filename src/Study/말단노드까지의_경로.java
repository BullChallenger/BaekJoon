package Study;

import java.util.ArrayDeque;
import java.util.Queue;

public class 말단노드까지의_경로 {

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(DFS(root, 0));
        System.out.println(BFS(root));
    }

    private static int DFS(Node root, int L) {
        if (root.lt == null && root.rt == null) return L;
        else {
            return Math.min(DFS(root.lt, L + 1), DFS(root.rt, L + 1));
        }
    }

    private static int BFS(Node root) {
        Queue<Node> Q = new ArrayDeque<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node current = Q.poll();
                if (current.lt == null && current.rt == null) return L;
                if (current.lt != null) Q.offer(current.lt);
                if (current.rt != null)Q.offer(current.rt);
            }
            L++;
        }
        return -1;
    }

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

}
