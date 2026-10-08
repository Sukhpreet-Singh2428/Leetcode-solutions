/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node bfs(Node node){
        Node ans = null;
        Queue<Node> qu = new ArrayDeque<>();
        HashMap<Integer, Node> vis = new HashMap<>();
        qu.offer(node);

        while(!qu.isEmpty()){
            Node temp = qu.poll();
            Node newNode;
            if(!vis.containsKey(temp.val)) newNode = new Node(temp.val);
            else newNode = vis.get(temp.val);

            if(ans == null) ans = newNode;

            vis.put(newNode.val, newNode);
            for(Node x : temp.neighbors){
                if(!vis.containsKey(x.val)){
                    Node newNeighbor = new Node(x.val);
                    qu.offer(x);
                    vis.put(newNeighbor.val, newNeighbor);
                    newNode.neighbors.add(newNeighbor);
                }
                else{
                    newNode.neighbors.add(vis.get(x.val));
                }
            }
        }

        return ans;
    }
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        return bfs(node);
    }
}