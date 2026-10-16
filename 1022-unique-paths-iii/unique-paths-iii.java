class Pair{
    int r;
    int c;
    int cover;
    boolean[][] vis;

    public Pair(int r, int c, int cover, boolean[][] vis){
        this.r = r;
        this.c = c;
        this.cover = cover;
        this.vis = vis;
    }
}
class Solution {
    public int bfs(int r, int c, int er, int ec, int[][] grid, int n, int m, int needCover){
        Queue<Pair> qu = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];
        vis[r][c] = true;
        qu.offer(new Pair(r, c, 1, vis));
        int cnt = 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!qu.isEmpty()){
            Pair p = qu.poll();

            if(p.r==er && p.c==ec){
                if(p.cover == needCover){
                    cnt++;
                }
                continue;
            }

            for(int i=0; i<4; i++){
                int row = p.r + drow[i];
                int col = p.c + dcol[i];

                if(row>=0 && row<n && col>=0 && col<m && grid[row][col]!=-1 && p.vis[row][col]==false){
                    boolean[][] newVis = new boolean[n][m];
                    for(int j=0; j<n; j++){
                        newVis[j] = p.vis[j].clone();
                    }

                    newVis[row][col] = true;
                    qu.offer(new Pair(row, col, p.cover+1, newVis));
                }
            }

        }

        return cnt;
    }
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cover = 0;
        int r = 0;
        int c = 0;
        int er = 0;
        int ec = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] != -1){
                    cover++;
                }
                if(grid[i][j] == 1){
                    r = i;
                    c = j;
                }
                else if(grid[i][j] == 2){
                    er = i;
                    ec = j;
                }
            }
        }

        return bfs(r, c, er, ec, grid, n, m, cover);
    }
}