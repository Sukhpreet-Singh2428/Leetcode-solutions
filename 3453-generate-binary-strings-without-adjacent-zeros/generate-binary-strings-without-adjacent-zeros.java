class Solution {
    public void generate(List<String> ans, String s, int n){
        if(s.length()==n){
            ans.add(s);
            return;
        }

        if(s.isEmpty() || s.charAt(s.length()-1) != '0'){
            generate(ans, s+"0", n);
        }

        generate(ans, s+"1", n);
    }
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, "", n);
        return ans;
    }
}