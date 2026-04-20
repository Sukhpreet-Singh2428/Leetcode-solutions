/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> qu = new ArrayDeque<>();
        qu.offer(root);
        
        while(!qu.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            int lvlNum = qu.size();
            for(int i=0; i<lvlNum; i++){
                Node temp = qu.peek();
                for(int j=0; j<temp.children.size(); j++){
                    qu.offer(temp.children.get(j));
                }

                qu.poll();
                ls.add(temp.val);
            }
            ans.add(ls);
        }

        return ans;
    }
}