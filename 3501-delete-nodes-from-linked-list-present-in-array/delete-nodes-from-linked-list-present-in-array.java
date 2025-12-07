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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head == null) return null;
        HashSet<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            st.add(nums[i]);
        }
        
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        ListNode temp = head;
        while(temp != null){
            if(st.contains(temp.val)){
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