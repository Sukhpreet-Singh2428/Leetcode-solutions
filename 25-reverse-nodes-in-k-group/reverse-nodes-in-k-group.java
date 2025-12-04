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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        // ListNode prev = null;
        ListNode temp = head;
        ListNode start = head;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == k){
                ListNode end = temp.next;
                ListNode rev = reverse(start, end);
                current.next = rev;
                while(current.next != null){
                    current = current.next;
                }
                cnt = 0;
                start = end;
                temp = end;
            }
            else{
                temp = temp.next;
            }
        }
        if(cnt > 0){
            current.next = start;
        }
        return dummyNode.next;
    }
}