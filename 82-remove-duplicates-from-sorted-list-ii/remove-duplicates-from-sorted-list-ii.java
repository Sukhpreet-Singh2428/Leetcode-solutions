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

        HashMap<Integer, Integer> mpp = new HashMap<>();
        ListNode temp = head;
        while(temp != null){
            mpp.put(temp.val, mpp.getOrDefault(temp.val, 0)+1);
            temp = temp.next;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        temp = head;
        while(temp != null){
            if(mpp.get(temp.val) > 1){
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