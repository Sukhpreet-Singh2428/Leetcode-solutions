class Solution {
    public static boolean helper(int start, int end, String s, Set<String> st, int[][] dp){
        if(dp[start][end] != -1){
            return dp[start][end] == 1 ? true : false;
        }
        if(end == s.length()-1){
            if(st.contains(s.substring(start, end+1))){
                return true;
            }
            return false;
        }

        if(st.contains(s.substring(start, end+1))){
            if(helper(end+1, end+1, s, st, dp)){
                dp[start][end] = 1;
                return true;
            }
        }

        dp[start][end] = helper(start, end+1, s, st, dp) ? 1 : 0;
        return dp[start][end] == 1 ? true : false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>(wordDict);
        int[][]  dp = new int[s.length()][s.length()];
        for(int[] x : dp){
            Arrays.fill(x, -1);
        }
        return helper(0, 0, s, st, dp);
    }
}