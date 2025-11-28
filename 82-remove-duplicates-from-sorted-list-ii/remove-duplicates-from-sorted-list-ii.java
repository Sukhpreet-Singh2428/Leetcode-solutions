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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        ListNode temp = head;
        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val){
                int data = temp.val;
                while(temp != null && temp.val == data){
                    temp = temp.next;
                }
            }
            else{
                current.next = temp;
                current = temp;
                temp = temp.next;
            }
        }
        current.next = temp;
        current = temp;
        if(current != null) current.next = null;

        return dummyNode.next;
    }
}