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
    public int[] nextLargerNodes(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        int[] ans = new int[len];
        head = reverse(head);

        temp = head;
        Stack<Integer> st = new Stack<>();
        int i=0;
        while(temp != null){
            int val = temp.val;
            i++;
            while(!st.isEmpty() && st.peek()<=val){
                st.pop();
            }
            ans[len-i] = st.isEmpty() ? 0 : st.peek();
            st.push(val);
            temp = temp.next;
        }

        return ans;
    }
}