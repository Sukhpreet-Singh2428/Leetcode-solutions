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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> mp = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int sum = 0;
        ListNode temp = dummy;

        while (temp != null) {
            sum += temp.val;
            mp.put(sum, temp);
            temp = temp.next;
        }

        sum = 0;
        temp = dummy;

        while (temp != null) {
            sum += temp.val;
            temp.next = mp.get(sum).next;
            temp = temp.next;
        }

        return dummy.next;
    }
}