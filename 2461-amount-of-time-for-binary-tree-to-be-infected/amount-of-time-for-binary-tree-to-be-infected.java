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
    TreeNode startingNode;
    public void buildGraph(TreeNode node, HashMap<TreeNode, List<TreeNode>> graph, int start){
        if(node==null){
            return;
        }

        if(node.val == start){
            startingNode = node;
        }

        if(graph.containsKey(node)){
            TreeNode left = node.left;
            TreeNode right = node.right;

            if(left!=null) graph.get(node).add(left);
            if(right!=null) graph.get(node).add(right);

            if(left!=null){
                if(graph.containsKey(left)){
                    graph.get(left).add(node);
                }
                else{
                    List<TreeNode> ls = new ArrayList<>();
                    ls.add(node);
                    graph.put(left, ls);
                }
            }

            if(right!=null){
                if(graph.containsKey(right)){
                    graph.get(right).add(node);
                }
                else{
                    List<TreeNode> ls = new ArrayList<>();
                    ls.add(node);
                    graph.put(right, ls);
                }
            }
        }
        else{
            TreeNode left = node.left;
            TreeNode right = node.right;

            List<TreeNode> list = new ArrayList<>();
            if(left!=null) list.add(left);
            if(right!=null) list.add(right);
            graph.put(node, list);

            if(left!=null){
                if(graph.containsKey(left)){
                    graph.get(left).add(node);
                }
                else{
                    List<TreeNode> ls = new ArrayList<>();
                    ls.add(node);
                    graph.put(left, ls);
                }
            }

            if(right!=null){
                if(graph.containsKey(right)){
                    graph.get(right).add(node);
                }
                else{
                    List<TreeNode> ls = new ArrayList<>();
                    ls.add(node);
                    graph.put(right, ls);
                }
            }
        }

        buildGraph(node.left, graph, start);
        buildGraph(node.right, graph, start);
    }
    public int bfs(HashMap<TreeNode, List<TreeNode>> graph){
        HashSet<TreeNode> vis = new HashSet<>();

        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.offer(startingNode);
        vis.add(startingNode);
        int cnt = -1;

        while(!qu.isEmpty()){
            int lvl = qu.size();

            for(int i=0; i<lvl; i++){
                TreeNode node = qu.peek();
                qu.poll();

                for(TreeNode it : graph.get(node)){
                    if(!vis.contains(it)){
                        vis.add(it);
                        qu.offer(it);
                    }
                }
            }

            cnt++;
        }

        return cnt;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
        startingNode = null;
        buildGraph(root, graph, start);

        return bfs(graph);
    }
}