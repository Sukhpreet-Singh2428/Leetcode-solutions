class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        HashMap<Character, Integer> mp = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        int r = 0;

        while(r < n){
            char c = s.charAt(r);

            if(mp.containsKey(c)){
                if(mp.get(c) >= l){
                    l = mp.get(c) + 1;
                }
            }

            int len = r-l+1;
            maxLen = Math.max(maxLen, len);

            mp.put(c, r);
            r++;
        }

        return maxLen;
    }
}