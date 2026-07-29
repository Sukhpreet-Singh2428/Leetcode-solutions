class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public boolean bfs(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        Queue<Pair> qu = new ArrayDeque<>();

        // Diagonals starting from the first row
        for(int j=0; j<m; j++){
            HashSet<Integer> st = new HashSet<>();
            qu.offer(new Pair(0, j));

            while(!qu.isEmpty()){
                int r = qu.peek().row;
                int c = qu.peek().col;
                st.add(matrix[r][c]);
                if(st.size() > 1) return false; 
                qu.poll();

                int drow = r+1;
                int dcol = c+1;
                if(drow<n && dcol<m){
                    qu.offer(new Pair(drow, dcol));
                }
            }
        }

        // Diagonals starting from the first col
        for(int i=0; i<n; i++){
            HashSet<Integer> st = new HashSet<>();
            qu.offer(new Pair(i, 0));

            while(!qu.isEmpty()){
                int r = qu.peek().row;
                int c = qu.peek().col;
                st.add(matrix[r][c]);
                if(st.size() > 1) return false; 
                qu.poll();

                int drow = r+1;
                int dcol = c+1;
                if(drow<n && dcol<m){
                    qu.offer(new Pair(drow, dcol));
                }
            }
        }

        return true;
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean ans = bfs(matrix);

        return ans;
    }
}