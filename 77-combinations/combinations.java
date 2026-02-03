class Solution {
    public static void combination(int idx, List<List<Integer>> ans, List<Integer> ls, int k, int n){
        if(ls.size()==k){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(ls.size()>k){
            return;
        }
        if(idx==n){
            return;
        }
        ls.add(idx+1);
        combination(idx+1, ans, ls, k, n);
        ls.remove(ls.size()-1);
        combination(idx+1, ans, ls, k, n);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        combination(0, ans, ls, k, n);
        return ans;
    }
}