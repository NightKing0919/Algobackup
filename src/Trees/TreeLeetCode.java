package Trees;

public class TreeLeetCode {

    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p.val != q.val) return false;
        if (p.left != null && q.left != null) {
            if (!isSame(p, q)) return false;
        }
        return true;
    }

    static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;if(p!=null && q==null)return false;if(p==null && q!=null)return false;
        if (p.left.val != q.left.val && p.right.val != q.right.val) return false;
        return (isSame(p.left,q.left) && isSame(p.right,q.right));

    }

    static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}
