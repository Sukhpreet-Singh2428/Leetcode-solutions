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
    public ListNode mergeNodes(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        ListNode temp = head.next;
        int sum = 0;

        while(temp != null){
            if(temp.val == 0){
                ListNode newNode = new ListNode(sum);
                current.next = newNode;
                current = newNode;
                temp = temp.next;
                sum = 0;
            }
            else{
                sum += temp.val;
                temp = temp.next;
            }
        }
        current.next = null;

        return dummyNode.next;
    }
}