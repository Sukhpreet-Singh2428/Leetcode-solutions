class Node{
    int row;
    int col;
    int val;

    public Node(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<Node> qu = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        qu.offer(new Node(0, 0, matrix[0][0]));

        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;

        int cnt = 0;
        while(!qu.isEmpty()){
            Node node = qu.poll();

            if(node.col+1<n && vis[node.row][node.col+1]==false){
                qu.offer(new Node(node.row, node.col+1, matrix[node.row][node.col+1]));
                vis[node.row][node.col+1] = true;
            }
            if(node.row+1<n && vis[node.row+1][node.col]==false){
                qu.offer(new Node(node.row+1, node.col, matrix[node.row+1][node.col]));
                vis[node.row+1][node.col] = true;
            } 

            cnt++;
            if(cnt == k){
                return node.val;
            }
        }

        return -1;
    }
}