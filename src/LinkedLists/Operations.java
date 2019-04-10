package LinkedLists;

public class Operations {
    public static void main(String[] args) {

    }

    static ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode cur = head;
        if (head == null) return head;
        if (head.next == null && head.data != val) return head;
        ListNode next = cur.next;

        while (cur.next != null) {
            if (cur.data == val) {
                if (prev == null) {
                    head = cur.next;
                    cur = cur.next;
                } else {
                    prev.next = cur.next;
                    cur = cur.next;
                }
            } else {
                prev = cur;
                cur = cur.next;
            }

        }
        if (cur.next == null && cur.data == val) {
            if (prev == null) head = null;
            else prev.next = null;
        }
        return head;
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        if (head == null) return false;

        while (p1.next != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) return true;
            if (p2 == null || p1 == null) return false;
        }
        return false;
    }

    static void deleteNode(ListNode node) { //If only access to the to-be-deleted node is given
        node.data = node.next.data;
        node.next = node.next.next;
    }

}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        next = null;
    }
}
