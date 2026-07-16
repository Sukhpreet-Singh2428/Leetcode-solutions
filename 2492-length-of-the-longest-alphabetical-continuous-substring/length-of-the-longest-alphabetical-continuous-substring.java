class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length();

        int l = 0;
        int r = 0;
        int maxLen = 0;
        char next = 'a';

        while(r < n){
            char c = s.charAt(r);
            if(r==0 || c!=next){
                l = r;
            }
            next = (char)(c + 1);
            maxLen = Math.max(maxLen, r-l+1);

            r++;
        }

        return maxLen;
    }
}