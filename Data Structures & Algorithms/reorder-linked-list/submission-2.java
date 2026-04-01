class Solution {
    private ListNode left;

    public void reorderList(ListNode head) {
        left = head;
        recurse(head);
    }

    private void recurse(ListNode right) {
        if (right == null) return;

        recurse(right.next);

        // stop condition: pointers met or crossed
        if (left == null) return;
        if (left == right || left.next == right) {
            right.next = null;
            left = null;
            return;
        }

        // weave nodes
        ListNode nextLeft = left.next;
        left.next = right;
        right.next = nextLeft;
        left = nextLeft;
    }
}
