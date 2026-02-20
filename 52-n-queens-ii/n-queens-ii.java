class Solution {
    public static boolean isPlacingPossible(List<String> board, int row, int col){
        int r = row;
        int c = col;

        // upper 
        while(r>=0){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
        }

        // left diagonal 
        r = row;
        c = col;
        while(r>=0 && c>=0){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
            c--;
        }

        // right diagonal
        r = row;
        c = col;
        while(r>=0 && c<board.size()){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
            c++;
        }

        return true;
    }
    public static void func(int row, List<String> board, List<List<String>> ans, int n){
        if(row == n){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int col = 0; col<board.get(row).length(); col++){
            if(isPlacingPossible(board, row, col)){
                char[] rowArr = board.get(row).toCharArray();
                rowArr[col] = 'Q';
                board.set(row, new String(rowArr));

                func(row+1, board, ans, n);

                rowArr[col] = '.';
                board.set(row, new String(rowArr));
            }
        }
    }
    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        for(int i=0; i<n; i++){
            String str = "";
            for(int j=0; j<n; j++){
                str += ".";
            }
            board.add(str);
        }

        func(0, board, ans, n);

        return ans.size();
    }
}