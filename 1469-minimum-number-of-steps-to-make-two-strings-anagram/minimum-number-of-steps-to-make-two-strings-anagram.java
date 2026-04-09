class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0)-1);
        }

        int cnt = 0;
        for(char key : mp.keySet()){
            if(mp.get(key) < 0){
                cnt += Math.abs(mp.get(key));
            }
        }

        return cnt;
    }
}