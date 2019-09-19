package Trees;

public class DistTwoNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(dist(root, root.left.left, root));
    }

    static int dist(TreeNode root, TreeNode a, TreeNode b) {
        TreeNode ancestor = LCAA(root, a, b);
        int d1 = traverse(ancestor, a, 0);
        int d2 = traverse(ancestor, b, 0);
        return d1 + d2;
    }

    static int traverse(TreeNode ancestor, TreeNode a, int level) {
        if (ancestor == null) return -1;
        if (ancestor.val == a.val) return level;
        int left = traverse(ancestor.left, a, level + 1);
        if (left == -1)
            return traverse(ancestor.right, a, level + 1);
        return left;
    }

    static TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) return null;
        if (root.val == a.val || root.val == b.val) return root;

        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a, b);
        if (left != null && right != null) return root;
        else return left == null ? right : left;
    }

    static TreeNode LCAA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) return null;
        if (root == a || root == b) return root;

        TreeNode left = LCAA(root.left, a, b);
        TreeNode right = LCAA(root.right, a, b);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
