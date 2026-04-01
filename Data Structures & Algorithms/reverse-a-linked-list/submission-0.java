/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode first = head;
        ListNode second = head.next;
        while(second!=null){
            ListNode next = second.next;
            first.next = prev;
            prev = first;
            next = second.next;
            second.next = first;
            first = second;
            second = next;
        }
        return first;
    }
}
