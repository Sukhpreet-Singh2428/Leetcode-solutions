class Solution {
    public static void generate(List<String> ans, String s, int open, int close, int n){
        if(open > n){
            return;
        }
        if(open + close == 2*n && open==close){
            ans.add(s);
            return;
        }
        generate(ans, s+'(', open+1, close, n);
        if(open > close){
            generate(ans, s+')', open, close+1, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, "", 0, 0, n);
        return ans;
    }
}