class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<target.length(); i++){
            char c = target.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int cnt = Integer.MAX_VALUE;
        for(char key : map.keySet()){
            if(!mp.containsKey(key)) return 0;
            cnt = Math.min(cnt, mp.get(key)/map.get(key));
        }

        return cnt;
    }
}