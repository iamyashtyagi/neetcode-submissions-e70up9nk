class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int n = list.size();
        int i = 0, j = n - 1;
        ListNode curr = head;

        while (i < j) {
            curr.next = list.get(j);
            curr = curr.next;

            curr.next = list.get(i + 1);
            curr = curr.next;

            i++;
            j--;
        }

        // Terminate the list to avoid cycles
        curr.next = null;
    }
}
