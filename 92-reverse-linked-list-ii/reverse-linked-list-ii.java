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
    public static ListNode reverse(ListNode start, ListNode end){
        ListNode temp = start;
        ListNode prev = null;
        ListNode next = null;
        while(temp != end){
            next = temp.next;
            temp.next = prev;
            prev = temp;

            temp = next;
        }

        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode temp = head;
        ListNode start = null;
        ListNode startPrev = null;
        ListNode end = null;
        ListNode endNext = null;
        ListNode prev = null;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt > right+1) break;
            if(cnt == left){
                start = temp;
                startPrev = prev;
            }
            if(cnt == right+1){
                end = temp;
                endNext = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
        ListNode rev = reverse(start, end);
        if(startPrev != null){
            startPrev.next = rev;
        }
        else{
            head = rev;
        }
        start.next = end;
        
        return head;
    }
}