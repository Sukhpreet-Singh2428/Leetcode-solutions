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
    public ListNode reverseLL(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseLL(l1);
        l2 = reverseLL(l2);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        int carry = 0;
        while(temp1 != null || temp2 != null){
            int sum = carry;
            if(temp1 != null) sum += temp1.val;
            if(temp2 != null) sum += temp2.val;
            ListNode temp = new ListNode(sum%10);
            carry = sum/10;
            current.next = temp;
            current = temp;
            
            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }
        if(carry != 0){
            ListNode temp = new ListNode(carry);
            current.next = temp;
        }
        
        ListNode result = reverseLL(dummyNode.next);
        while(result != null && result.val == 0 && result.next != null){
            result = result.next;
        }
        return result;
    }
}