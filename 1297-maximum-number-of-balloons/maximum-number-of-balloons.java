class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }

        String s = "balloon";
        int cnt = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!mp.containsKey(c)) return 0;
            if(c=='l' || c=='o'){
                cnt = Math.min(cnt, mp.get(c)/2);
            }
            cnt = Math.min(cnt, mp.get(c));
        }

        return cnt;
    }
}