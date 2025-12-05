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
    public static ListNode Middle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        ListNode mid = Middle(head);
        ListNode second = reverse(mid.next);
        mid.next = null;  

        ListNode first = head;

        while(second != null){
            ListNode nxt1 = first.next;
            ListNode nxt2 = second.next;

            first.next = second;
            second.next = nxt1;

            first = nxt1;
            second = nxt2;
        }
    }
}