class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        List<Integer> ls = new ArrayList<>();
        for(int[] row : grid){
            for(int col : row){
                ls.add(col);
            }
        }

        k = k%ls.size();
        int idx = ls.size() - k;
        List<Integer> temp = new ArrayList<>();
        for(int i=idx; i<ls.size(); i++){
            temp.add(ls.get(i));
        }
        for(int i=0; i<idx; i++){
            temp.add(ls.get(i));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<ls.size(); i+=m){
            List<Integer> row = new ArrayList<>();
            for(int j=i; j<i+m; j++){
                row.add(temp.get(j));
            }
            ans.add(new ArrayList<>(row));
        }

        return ans;
    }
}