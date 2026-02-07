class Solution {
    public static void combinations(int idx, String s, String digits, List<String> ans, String[] combo, int n){
        if(idx == n){
            ans.add(s);
            return;
        }

        int number = digits.charAt(idx) - '0';
        String str = combo[number];
        for(int i=0; i<str.length(); i++){
            combinations(idx+1, s+str.charAt(i), digits, ans, combo, n);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] combo = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combinations(0, "", digits, ans, combo, digits.length());
        return ans;
    }
}