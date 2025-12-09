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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while(temp != null){
            if(temp.val < x){
                ListNode newNode = new ListNode(temp.val);
                current.next = newNode;
                current = newNode;
            }
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            if(temp.val < x){
                temp = temp.next;
            }
            else{
                current.next = temp;
                current = temp;
                temp = temp.next;
            }
        }
        current.next = null;

        return dummyNode.next;
    }
}