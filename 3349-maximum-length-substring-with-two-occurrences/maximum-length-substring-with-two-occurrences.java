class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();

        int l = 0;
        int r = 0;
        int maxLen = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        while(r<n){
            char c = s.charAt(r);
            mp.put(c, mp.getOrDefault(c, 0)+1);

            if(mp.get(c) > 2){
                while(mp.get(c) > 2){
                    char left = s.charAt(l);
                    mp.put(left, mp.get(left)-1);
                    if(mp.get(left)==0){
                        mp.remove(left);
                    }
                    l++;
                }
            }

            maxLen = Math.max(maxLen, r-l+1);

            r++;
        }

        return maxLen;
    }
}