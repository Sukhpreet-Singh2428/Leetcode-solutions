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
    public static ListNode mergeTwoSortLL(ListNode head1, ListNode head2){
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                current.next = temp1;
                current = temp1;
                temp1 = temp1.next;
            }
            else{
                current.next = temp2;
                current = temp2;
                temp2 = temp2.next;
            }
        }

        if(temp1 != null){
            current.next = temp1;
        }
        if(temp2 != null){
            current.next = temp2;
        }

        return dummyNode.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        ListNode ans = lists[0];
        for(int i=1; i<lists.length; i++){
            ans = mergeTwoSortLL(ans, lists[i]);
        }

        return ans;
    }
}