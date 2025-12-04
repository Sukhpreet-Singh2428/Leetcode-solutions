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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        ListNode first = null;
        ListNode last = null;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(first != null && last != null) break;
            if(cnt == k) first = temp;
            if(cnt == len-k+1) last = temp;
            temp = temp.next;
        }
        int x = first.val;
        first.val = last.val;
        last.val = x;

        return head;
    }
}