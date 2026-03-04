class Solution {
    public static boolean check(int i, int j, int[][] mat){
        int u = i;
        int v = j;
        while(v<mat[0].length){
            if(mat[u][v]==1 && v!=j) return false;
            v++;
        }
        v = j;
        while(v>=0){
            if(mat[u][v]==1 && v!=j) return false;
            v--;
        }
        v = j;
        while(u<mat.length){
            if(mat[u][v]==1 && u!=i) return false;
            u++;
        }
        u = i;
        while(u>=0){
            if(mat[u][v]==1 && u!=i) return false;
            u--;
        }

        return true;
    }
    public int numSpecial(int[][] mat) {
        int cnt = 0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1){
                    if(check(i, j, mat)){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}