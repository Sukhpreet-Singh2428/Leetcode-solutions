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
class tuple {
    int row;
    int col;
    TreeNode node;

    public tuple(int row, int col, TreeNode node){
        this.row = row;
        this.col = col;
        this.node = node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;

        Queue<tuple> qu = new ArrayDeque<>();
        qu.offer(new tuple(0, 0, root));

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> mp = new TreeMap<>();

        while(!qu.isEmpty()){
            int lvl = qu.size();

            for(int i=0; i<lvl; i++){
                tuple curr = qu.peek();

                if(!mp.containsKey(curr.col)){
                    TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
                    List<Integer> ls = new ArrayList<>();
                    ls.add(curr.node.val);
                    tm.put(curr.row, ls);
                    mp.put(curr.col, tm);
                }
                else{
                    if(!mp.get(curr.col).containsKey(curr.row)){
                        List<Integer> ls = new ArrayList<>();
                        ls.add(curr.node.val);
                        mp.get(curr.col).put(curr.row, ls);
                    }
                    else{
                        mp.get(curr.col).get(curr.row).add(curr.node.val);
                        Collections.sort(mp.get(curr.col).get(curr.row));
                    }
                }

                if(curr.node.left != null) qu.offer(new tuple(curr.row+1 ,curr.col-1, curr.node.left));
                if(curr.node.right != null) qu.offer(new tuple(curr.row+1, curr.col+1, curr.node.right));

                qu.poll();
            }
        }

        for(int key : mp.keySet()){
            List<Integer> ls = new ArrayList<>();
            for(int x : mp.get(key).keySet()){
                for(int i=0; i<mp.get(key).get(x).size(); i++){
                    ls.add(mp.get(key).get(x).get(i));
                }
            }
            ans.add(ls);
        }

        return ans;
    }
}