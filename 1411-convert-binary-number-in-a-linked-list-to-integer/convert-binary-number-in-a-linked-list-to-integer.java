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
    public static ListNode reverse(ListNode head){
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
    public int getDecimalValue(ListNode head) {
        head = reverse(head);

        long converter = 1;
        int ans = 0;
        ListNode temp = head;
        while(temp != null){
            ans += converter * temp.val;
            converter = converter*2;
            temp = temp.next;
        }

        return ans;
    }
}