class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;

        for(int i=0; i<s.length(); i++){
            HashMap<Character, Integer> mp = new HashMap<>();
            for(int j=i; j<s.length(); j++){
                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0)+1);
                boolean check = false;
                for(char key : mp.keySet()){
                    if(mp.get(key) < k){
                        check = true;
                        break;
                    }
                }
                if(check) continue;
                ans = Math.max(ans, j-i+1);
            }
        }

        return ans;
    }
}