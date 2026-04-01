class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Handle edge case: deleting head
        if (getLength(head) == n) return head.next;

        remove(head, n);
        return head;
    }

    private int remove(ListNode curr, int n) {
        if (curr == null) return 0;

        int pos = remove(curr.next, n) + 1;

        // delete next node instead of current
        if (pos == n + 1) {
            curr.next = curr.next.next;
        }

        return pos;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}