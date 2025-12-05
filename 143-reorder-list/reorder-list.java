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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        temp = head;
        ArrayList<Integer> reorder = new ArrayList<>();
        int i = 0;
        int j = arr.size()-1;
        while(i<=j){
            reorder.add(arr.get(i));
            if(i != j) reorder.add(arr.get(j));
            i++;
            j--;
        }
        i = 0;
        while(temp != null){
            temp.val = reorder.get(i);
            i++;
            temp = temp.next;
        }
    }
}