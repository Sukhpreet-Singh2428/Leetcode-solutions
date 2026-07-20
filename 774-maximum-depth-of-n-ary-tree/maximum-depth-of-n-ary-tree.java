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

class Pair{
    Node node;
    int lvl;

    public Pair(Node node, int lvl){
        this.node = node;
        this.lvl = lvl;
    }
}
class Solution {
    public int maxDepth(Node root) {
        if(root==null) return 0;

        Queue<Pair> qu = new ArrayDeque<>();
        int depth = 0;
        qu.offer(new Pair(root, 1));

        while(!qu.isEmpty()){
            Pair pair = qu.poll();
            depth = Math.max(depth, pair.lvl);
            for(Node x : pair.node.children){
                qu.offer(new Pair(x, pair.lvl+1));
            }
        }

        return depth;
    }
}