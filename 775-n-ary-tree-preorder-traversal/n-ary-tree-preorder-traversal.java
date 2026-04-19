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
    public void func(Node root, List<Integer> ls){
        if(root == null){
            return;
        }

        ls.add(root.val);
        if(root.children != null){
            for(int i=0; i<root.children.size(); i++){
                func(root.children.get(i), ls);
            }
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> ls = new ArrayList<>();
        func(root, ls);
        return ls;
    }
}