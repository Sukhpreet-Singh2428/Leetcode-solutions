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
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = null;
        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        if(head == null ||head.next == null){
            return head;
        }

        head = reverse(head);
        ListNode temp = head;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int maxi = Integer.MIN_VALUE;
        while(temp != null){
            if(temp.val >= maxi){
                current.next = temp;
                current = temp;
            }
            maxi = Math.max(temp.val, maxi);
            temp = temp.next;
        }
        current.next = null;

        return reverse(dummyNode.next);
    }
}