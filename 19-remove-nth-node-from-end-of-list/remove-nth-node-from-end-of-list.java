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
    public static ListNode deleteHead(ListNode head){
        if(head == null) return null;
        head = head.next;
        return head;
    }
    public static ListNode deleteTail(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode tail = head;
        while(tail.next.next != null){
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int k = len-n+1;
        if(k==1){
            return deleteHead(head);
        }
        if(k==len){
            return deleteTail(head);
        }
        temp = head;
        int cnt = 0;
        ListNode prev = null;
        while(temp != null){
            cnt++;
            if(cnt == k){
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}