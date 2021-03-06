package LinkedLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Operations {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        print(ins(head, 1, 2));
    }

    static boolean isPalindrome(ListNode head) { // VERY EFFICIENT SOLUTION ... previous was 7 ms and this is 1ms. Find Mid and reverse one part,check both.
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode right = mid.next;
        mid.next = null;
        right = reverse(right);

        while (right != null && head != null) {
            if (right.val != head.val)
                return false;
            right = right.next;
            head = head.next;
        }
        return true;
    }

    static boolean isPalindrome2(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            stk.push(new Integer(temp.val));
            list.add(new Integer(temp.val));
            temp = temp.next;
        }
        System.out.println("stk = " + stk);
        System.out.println("list = " + list);
        for (int i = 0; i < (list.size() / 2); i++) {
            int x1 = stk.pop();
            int x2 = list.get(i);
            if (x1 == x2) continue;
            else return false;
        }
        return true;
    }

    static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode res = head, a = head, b = head.next;
        int cur = -1;
        while (b != null) {
            cur = a.val;
            if (b.val != cur) {
                a.next = b;
                b = b.next;
                a = a.next;
            } else {
                b = b.next;
            }
        }
        a.next = null;
        return res;
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = null;
        ListNode res = new ListNode(0);
        temp = res;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            sum = carry % 10;
            if (carry > 9) carry = 1;
            else carry = 0;
            temp.next = new ListNode(sum);
            temp = temp.next;

        }
        return res.next;

    }

    static ListNode swapPairs(ListNode head) {
        return swapHelper(head);
    }

    static ListNode swapHelper(ListNode head) {
        ListNode node = head;
        if (node == null) return null;
        if (node.next == null) return node;
        ListNode temp = node.next;
        node.next = swapHelper(node.next.next);
        temp.next = node;
        return temp;
    }

    static ListNode swapPairs2(ListNode head) {
        if (head == null) return null;
        ListNode a = head;
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        ListNode b = head.next;
        if (b == null) return a;
        ListNode c = b.next;
        while (a != null) {
            b.next = null;
            ListNode t = reverse(a);
            res.next = t;
            res = res.next.next;
            a = c;
            if (a == null) break;
            b = a.next;
            if (b == null) {
                res.next = a;
                break;
            }
            c = b.next;
        }
        return dummy.next;
    }

    static ListNode ins(ListNode head, int data, int position) {
        if (position == 1) {
            ListNode res = new ListNode(data);
            res.next = head;
            return res;
        }
        ListNode res = head;//res=res.next;
        while (res != null && position-- != 1) {
            res = res.next;
        }
        ListNode temp = res.next;
        res.next = new ListNode(data);
        res.next.next = temp;
        return head;
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = null;
        ListNode originalHead = null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            temp = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            temp = new ListNode(l2.val);
            l2 = l2.next;
        }
        originalHead = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) temp.next = l1;
        else if (l2 != null) temp.next = l2;
        return originalHead;

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
        } else bhook = ahook;
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
