package Trees;

public class TreeNode    {

    TreeNode left, right;
    int val;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val;
    }


}
