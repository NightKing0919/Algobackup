package Trees;

public class BinaryTree {

    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        printInorder(tree.root);
        System.out.println();
        printPreOrder(tree.root);
        System.out.println();
        printPostOrder(tree.root);
    }

    static void printInorder(Node node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    static void printPreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    static void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }
}
