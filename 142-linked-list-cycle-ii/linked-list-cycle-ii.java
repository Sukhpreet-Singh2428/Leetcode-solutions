/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        HashSet<ListNode> st = new HashSet<>();

        ListNode temp = head;
        while(temp != null){
            if(st.contains(temp)){
                return temp;
            }
            else{
                st.add(temp);
                temp = temp.next;
            }
        }

        return null;
    }
}