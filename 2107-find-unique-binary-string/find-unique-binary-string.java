class Solution {
    public static boolean generate(String s, HashSet<String> st, int n, String[] ans){
        if(s.length() == n){
            if(!st.contains(s)){
                ans[0] = s; 
                return true;
            }
            else return false;
        }

        if(generate(s+"0", st, n, ans) == true){
            return true;
        }
        if(generate(s+"1", st, n, ans) == true){
            return true;
        }
        return false;
    }
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> st = new HashSet<>();
        for(String s : nums){
            st.add(s);
        }
        String[] ans = new String[1];
        generate("", st, n, ans);
        return ans[0];
    }
}