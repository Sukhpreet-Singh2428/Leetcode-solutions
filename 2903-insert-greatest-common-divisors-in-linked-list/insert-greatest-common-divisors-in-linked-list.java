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
    public static int gcd(int a, int b){
        while(a>0 && b>0){
            if(a>b) a = a%b;
            else b = b%a;
        }
        if(a==0) return b;
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        while(temp != null && temp.next != null){
            ListNode next = temp.next;
            int val = gcd(temp.val, temp.next.val);
            ListNode newNode = new ListNode(val);
            temp.next = newNode;
            newNode.next = next;
            temp = newNode.next;
        }

        return head;
    }
}