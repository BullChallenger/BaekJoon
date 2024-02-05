package Study;

import java.util.*;

public class DFS와BFS {

    private static boolean[][] board;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt(); // 노드의 개수
        final int M = sc.nextInt(); // 간선의 개수
        final int V = sc.nextInt(); // 시작 노드의 번호

        board = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            int firstNode = sc.nextInt();
            int secondNode = sc.nextInt();

            board[firstNode][secondNode] = true;
            board[secondNode][firstNode] = true;
        }

        DFS(V);
        visited = new boolean[N + 1];
        BFS(V);
    }

    private static void DFS(int V) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        stack.push(V);
        while (!stack.isEmpty()) {
            int nextNode = stack.pop();
            if (visited[nextNode]) {
                continue;
            } else {
                visited[nextNode] = true;
            }
            sb.append(nextNode);
            sb.append(' ');
            for (int i = board[nextNode].length - 1; i >= 1; i--) {
                if (!board[nextNode][i]) {
                    continue;
                }
                stack.push(i);
            }
        }

        System.out.println(sb);
    }

    private static void visitNode(int V, Stack<Integer> tower) {
        tower.push(V);
        visited[V] = true;
    }

    private static void BFS(int V) {
        Queue<Integer> Q = new LinkedList<>();
        visitNode(V, Q);

        while (!Q.isEmpty()) {
            int targetNode = Q.poll();
            System.out.print(targetNode);
            for (int i = 1; i < board[targetNode].length; i++) {
                if (!visited[i] && board[targetNode][i]) {
                    visitNode(i, Q);
                }
            }
            System.out.print(" ");
        }
    }

    private static void visitNode(int V, Queue<Integer> Q) {
        Q.offer(V);
        visited[V] = true;
    }

}
