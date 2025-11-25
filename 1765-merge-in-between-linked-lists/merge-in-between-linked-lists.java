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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp1 = list1;
        // ListNode dummyNode = new ListNode(-1);
        // ListNode current = dummyNode;
        int cnt = -1;
        while(temp1 != null){
            cnt++;
            // current.next = temp1;
            if(cnt == a-1) break;
            // current = temp1;
            temp1 = temp1.next;
        }
        // current = temp1;
        ListNode last = temp1;
        temp1 = temp1.next;
        // ListNode last = current;

        ListNode temp2 = list2;
        while(temp2.next != null){
            temp2 = temp2.next;
        }

        while(temp1 != null){
            cnt++;
            if(cnt <= b){
                temp1 = temp1.next;
            }
            else{
                temp2.next = temp1;
                temp2 = temp1;
                temp1 = temp1.next;
            }
        }
        temp2.next = null;

        last.next = list2;

        // return dummyNode.next;
        return list1;
    }
}