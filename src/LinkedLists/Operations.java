package LinkedLists;

public class Operations {

    static Node reverse(Node head) {
        Node prev = null;
        Node next = null;
        Node current = head;

        while (current != null) {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    static boolean hasCycle(Node head) {
        Node p1=head;
        Node p2=head;

        if(head==null)return false;

        while(p1.next!=null && p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2)return true;
            if(p2==null || p1==null)return false;
        }
        return false;
    }
    static void deleteNode(Node node){
        node.data=node.next.data;
        node.next=node.next.next;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}
