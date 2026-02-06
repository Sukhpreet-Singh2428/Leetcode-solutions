class Solution {
    public static boolean wordSearch(int idx, int i, int j, char[][] board, int n, int m, String word){
        if(idx == word.length()){
            return true;
        }
        if(board[i][j] == ' ' || board[i][j] != word.charAt(idx)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean ans = false;
        // top
        if(i-1 >= 0){
            ans = ans || wordSearch(idx+1, i-1, j, board, n, m, word);
        }
        // bottom
        if(i+1 < n){
            ans = ans || wordSearch(idx+1, i+1, j, board, n, m, word);
        }
        // left
        if(j-1 >= 0){
            ans = ans || wordSearch(idx+1, i, j-1, board, n, m, word);
        }
        // right
        if(j+1 < m){
            ans = ans || wordSearch(idx+1, i, j+1, board, n, m, word);
        }

        board[i][j] = temp;
        return ans;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        if(word.length()==1 && board[0][0] == word.charAt(0)){
            return true;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(wordSearch(0, i, j, board, n, m, word)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}