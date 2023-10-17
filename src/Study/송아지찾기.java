package Study;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기 {

    private static int S;
    private static int C;
    private static int[] arr;

    public static void main(String[] args) {
        solution();
    }

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        S = sc.nextInt();
        C = sc.nextInt();

        Node root = new Node(S);
        root.lt = new Node(S - 1);
        root.rt = new Node(S + 1);
        root.mid = new Node(S + 5);
        BFS(root);
    }

    private static void BFS(Node root) {
        Queue<Node> Q = new ArrayDeque<>();
        arr = new int[10001];
        Q.offer(root);
        arr[root.location] = 1;
        int cnt = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node current = Q.poll();
                if (current.location == C) {
                    System.out.println(cnt);
                    return;
                }
                else {
                    int left = current.location - 1;
                    int middle = current.location + 1;
                    int right = current.location + 5;
                    if (left >= 0 && arr[left] != 1) {
                        arr[left] = 1;
                        current.lt = new Node(left);
                        Q.offer(current.lt);
                    }
                    if (arr[middle] != 1) {
                        arr[middle] = 1;
                        current.mid = new Node(middle);
                        Q.offer(current.mid);
                    }
                    if (arr[right] != 1) {
                        arr[right] = 1;
                        current.rt = new Node(right);
                        Q.offer(current.rt);
                    }
                }
            }
            cnt++;
        }
    }

    private static class Node {
        private int location;

        private Node lt;
        private Node mid;
        private Node rt;

        public Node(int location) {
            this.location = location;
            lt = rt = mid = null;
        }
    }
}
