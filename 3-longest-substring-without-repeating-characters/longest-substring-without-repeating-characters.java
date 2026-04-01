class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for(int i=0; i<s.length(); i++){
            HashSet<Character> st = new HashSet<>();
            int len = 0;
            for(int j=i; j<s.length(); j++){
                if(st.contains(s.charAt(j))){
                    break;
                }
                st.add(s.charAt(j));
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}