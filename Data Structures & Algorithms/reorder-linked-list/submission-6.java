class Solution {
    ListNode left;

    public void reorderList(ListNode head) {
        left = head;
        recurse(head);
    }

    private void recurse(ListNode right) {
        if (right == null) return;

        recurse(right.next);

        // if already finished, do nothing
        if (left == null) return;

        // meeting or crossing point
        if (left == right || left.next == right) {
            right.next = null;   // cut exactly once
            left = null;         // signal completion
            return;
        }

        // weave
        ListNode nextLeft = left.next;
        left.next = right;
        right.next = nextLeft;
        left = nextLeft;
    }
}
