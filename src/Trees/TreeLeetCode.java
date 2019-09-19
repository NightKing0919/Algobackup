package Trees;

import java.util.*;

public class TreeLeetCode {
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        //     root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(20);
        //root.left.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        System.out.println(isValidBSTIn(root));

    }

    static boolean isValidBSTIn(TreeNode root) {
        List<Integer> in = new LinkedList<>();
        getInroder(root, in);
        //System.out.println(in);
        for (int i = 0; i < in.size() - 1; i++) {
            if (in.get(i) > in.get(i + 1)) return false;
        }
        return true;
    }

    static void getInroder(TreeNode root, List<Integer> in) {
        if (root == null) return;
        getInroder(root.left, in);
        in.add(root.val);
        getInroder(root.right, in);
    }


    static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null) {
            if (root.left.val > root.val) return false;
        }
        if (root.right != null) {
            if (root.right.val < root.val) return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    static boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ((LinkedList<TreeNode>) q).add(root);
        ((LinkedList<TreeNode>) q).add(root);

        while (!q.isEmpty()) {
            TreeNode a = q.poll();
            TreeNode b = q.poll();
            if (a == null && b == null) continue;
            if (a == null || b == null) return false;
            if (a.val != b.val) return false;
            ((LinkedList<TreeNode>) q).add(a.left);
            ((LinkedList<TreeNode>) q).add(b.right);
            ((LinkedList<TreeNode>) q).add(a.right);
            ((LinkedList<TreeNode>) q).add(b.left);

        }
        return true;
    }

    static boolean isSymmetric(TreeNode root) {

        return isMirror(root, root);
    }

    static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        return (a.val == b.val) && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }


    static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        q.add(root.left.val);
        q.add(root.right.val);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int x1 = h(root.left);
        int x2 = h(root.right);
        if (x1 == -1 || x2 == -1) return false;
        if (Math.abs(x1 - x2) > 1) return false;
        return true;

    }

    static int h(TreeNode node) {
        if (node == null) return 0;
        int a = h(node.left);
        int b = h(node.right);
        if (a < 0 || b < 0) return -1;
        int x = Math.abs(1 + a - (1 + b));

        if (Math.abs(a - b) > 1) {
        }
        if (x > 1) return -1;

        return Math.max(1 + a, 1 + b);
    }

    static List<Integer> postOrderTraversal(TreeNode root) {

        //Uses linkedlist--AddFirst () to add from root in reverse, unlike inorder and preorder
        //Review this method
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root;

        while (!stk.isEmpty() || node != null) {
            if (node != null) {
                stk.push(node);
                ((LinkedList<Integer>) res).addFirst(node.val);
                node = node.right;
                //if (node == null && node.right!=null) node = node.right;
            } else {
                node = stk.pop().left;
            }
            //System.out.println(res);

        }
        return res;

    }

    static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode node = root;

        while (!stk.isEmpty() || node != null) {
            if (node != null) {
                res.add(node.val);
                stk.push(node);
                node = node.left;
            } else if (!stk.isEmpty()) {
                if (stk.peek().right != null) {
                    node = stk.pop().right;
                } else stk.pop();
            }
        }
        return res;
    }

    static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;

        while (!stk.isEmpty() || node != null) {
            if (node != null) {
                stk.push(node);
                node = node.left;
            } else {
                node = stk.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }


    static List<List<Integer>> levelOrder(TreeNode root) {
        //Use queue, put root first. then by size of queue, iterate and check if left/right valid, then add them to q
        //and add the first q element to linked list.
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ((LinkedList<TreeNode>) q).add(root);
        while (!q.isEmpty()) {
            int lev = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < lev; i++) {
                if (q.peek().left != null)
                    ((LinkedList<TreeNode>) q).add(q.peek().left);
                if (q.peek().right != null)
                    ((LinkedList<TreeNode>) q).add(q.peek().right);
                temp.add(q.poll().val);
            }
            res.add(temp);
        }
        return res;

    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    static TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {

        //If p and q are either side of root, root is LCA.
        //If p and Q are liss than root, traverse to left until satisfies
        //samething as 2nd but to the right
        int rdata = root.val;
        if (root == null) return null;
        if (p.val < rdata && q.val > rdata) {
            return root;
        }
        if (p.val < rdata && q.val < rdata) {
            return lowestCommonAncestorBST(root.left, p, q);
        } else if (p.val > rdata && q.val > rdata) {
            return lowestCommonAncestorBST(root.right, p, q);
        }
        return null;

    }

    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p.val != q.val) return false;
        if (p.left != null && q.left != null) {
            if (!isSame(p, q)) return false;
        }
        return true;
    }

    static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (p == null && q != null) return false;
        if (p.left.val != q.left.val && p.right.val != q.right.val) return false;
        return (isSame(p.left, q.left) && isSame(p.right, q.right));

    }

    static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}
