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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean func(TreeNode root, ListNode head){
        if(head==null){
            return true;
        }
        if(root==null){
            return false;
        }

        if(root.val != head.val){
            return false;
        }

        return func(root.left, head.next) || func(root.right, head.next);
    }
    public void traversal(TreeNode root, ListNode head, boolean[] ans){
        if(root==null){
            return;
        }
        if(ans[0]==true){
            return;
        } 

        ans[0] = func(root, head);
        traversal(root.left, head, ans);
        if(ans[0]==true){
            return;
        }
        traversal(root.right, head, ans);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean[] ans = new boolean[1];
        traversal(root, head, ans);
        return ans[0];
    }
}