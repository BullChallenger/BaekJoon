package Study;

public class 이진트리순회 {

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
        DFS_전위(root);
        System.out.println();
        DFS_중위(root);
        System.out.println();
        DFS_후위(root);
    }

    private static void DFS_전위(Node root) {
        System.out.print(root.data + " ");
        if (root.lt != null) DFS_전위(root.lt);
        if (root.rt != null) DFS_전위(root.rt);
    }

    private static void DFS_중위(Node root) {
        if (root.lt != null) DFS_중위(root.lt);
        System.out.print(root.data + " ");
        if (root.rt != null) DFS_중위(root.rt);
    }

    private static void DFS_후위(Node root) {
        if (root.lt != null) DFS_후위(root.lt);
        if (root.rt != null) DFS_후위(root.rt);
        System.out.print(root.data + " ");
    }
}
