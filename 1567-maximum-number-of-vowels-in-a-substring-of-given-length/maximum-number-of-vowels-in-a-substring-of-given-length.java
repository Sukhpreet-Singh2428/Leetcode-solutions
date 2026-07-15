class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();

        int l = 0;
        int r = 0;
        int maxNum = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        while(r < n){
            char c = s.charAt(r);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                mp.put(c, mp.getOrDefault(c, 0)+1);
            }

            if(r-l+1 > k){
                char left = s.charAt(l);
                if(mp.containsKey(left)){
                    mp.put(left, mp.get(left)-1);
                    if(mp.get(left)==0){
                        mp.remove(left);
                    }
                }
                l++;
            }

            if(r-l+1 == k){
                int total = 0;
                for(char key : mp.keySet()){
                    total += mp.get(key);
                }
                maxNum = Math.max(maxNum, total);
            }

            r++;
        }

        return maxNum;
    }
}