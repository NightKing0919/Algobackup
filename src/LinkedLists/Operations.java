package LinkedLists;

public class Operations {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        print(head);
        partition(head, 3);

    }

    static ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        ListNode before = null, bhook = null;
        ListNode after = null, ahook = null;
        if (head == null) return head;
        while (temp != null) {
            if (temp.val < x) {

                if (before == null) {
                    before = new ListNode(temp.val);
                    bhook = before;
                } else {
                    while (before.next != null) {
                        before = before.next;
                    }
                    before.next = new ListNode(temp.val);
                }
            } else if (temp.val >= x) {
                if (after == null) {
                    after = new ListNode(temp.val);
                    ahook = after;
                } else {
                    while (after.next != null) {
                        after = after.next;
                    }

                    after.next = new ListNode(temp.val);
                }
            }
            temp = temp.next;
        }
        if (before != null) {
            while (before.next != null) {
                before = before.next;
            }
            before.next = ahook;
        }else bhook=ahook;
        //print(bhook);
        return bhook;
    }


    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode lhook = null, rhook = null, cur = head;
        if (m < 2) lhook = null;
        if (n < 2) return head;
        for (int i = 0; i < n; i++) {
            if (m >= 2 && i == (m - 2)) lhook = cur;
            if (n >= 2 && i == (n - 1)) {
                rhook = cur.next;
                cur.next = null;
            }
            cur = cur.next;
        }
        ListNode revHead;
        if (lhook != null)
            revHead = reverse(lhook.next);
        else revHead = reverse(head);


        if (lhook != null) {
            lhook.next = revHead;
        } else head = revHead;
        while (revHead.next != null) {
            revHead = revHead.next;
        }
        if (rhook == null) return head;
        else revHead.next = rhook;
        return head;
    }

    static ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode cur = head;
        if (head == null) return head;
        if (head.next == null && head.val != val) return head;
        ListNode next = cur.next;

        while (cur.next != null) {
            if (cur.val == val) {
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
        if (cur.next == null && cur.val == val) {
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
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int data) {
        this.val = data;
        next = null;
    }
}
