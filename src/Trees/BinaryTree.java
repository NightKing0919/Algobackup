package Trees;

public class BinaryTree {

    Node root;
    public BinaryTree(int key){
        root=new Node(key);
    }
    public BinaryTree(){
        root=null;
    }
    public void setRoot(int key){
        root.key=key;
    }

}

class Node{
    int key;
    Node left,right;

    public Node(int item){
        key=item;
        left=right=null;
    }
}
