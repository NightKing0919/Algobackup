/*
package Trees;

import java.util.Stack;

public class BinaryTree {

    static int preIndex = 0;
    TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }


    public BinaryTree() {
        root = null;
    }

    static void printInorder(TreeNode treeNode) {
        if (treeNode == null) return;
        printInorder(treeNode.left);
        System.out.print(treeNode.val + " ");
        printInorder(treeNode.right);
    }

    static void printPreOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.val + " ");
        printPreOrder(treeNode.left);
        printPreOrder(treeNode.right);
    }

    static void printPostOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        printPostOrder(treeNode.left);
        printPostOrder(treeNode.right);
        System.out.print(treeNode.val + " ");
    }

    static void printInorderWithStack(TreeNode treeNode) {
        if (treeNode == null) return;
        TreeNode cur = treeNode;
        Stack<TreeNode> stk = new Stack<>();
        while (!stk.isEmpty() || cur != null) {

            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }

    }

    static int search(int[] arr, int x, int a, int b) {
        int i = 0;
        for (i = a; i < b; i++) {
            if (arr[i] == x) return i;
        }
        return i;
    }

    public static void main(String[] args) {
        int in1[] = {4, 2, 5, 1, 3, 6};
        int pre[] = {1, 2, 4, 5, 3, 6};
        new BinaryTree().printPostOrder(in1, pre, 0, in1.length - 1);
    }

    void printPostOrder(int[] in, int[] pre, int inStart, int inEnd) {
        System.out.println("inStart+\" \"+inEnd = " + inStart + " " + inEnd);
        if (inStart > inEnd) return;
        int root2 = 0;
        root2 = search(in, pre[preIndex++], inStart, inEnd);
        System.out.println("root2 = " + root2);
        printPostOrder(in, pre, inStart, root2 - 1);
        printPostOrder(in, pre, root2 + 1, inEnd);
        System.out.print(in[root2] + " ---->>");
    }
}
*/
