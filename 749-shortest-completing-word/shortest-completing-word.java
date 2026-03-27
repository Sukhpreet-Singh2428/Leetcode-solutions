class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<licensePlate.length(); i++){
            char c = licensePlate.charAt(i);
            c = Character.toLowerCase(c);
            if(c>='a' && c<='z'){
                mp.put(c, mp.getOrDefault(c, 0)+1);
            }
        }
        String ans = "";
        int shortest = Integer.MAX_VALUE;

        for(String s : words){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(mp.containsKey(c)){
                    map.put(c, map.getOrDefault(c, 0)+1);
                }
            }
            boolean not = false;
            for(char key : mp.keySet()){
                if(map.getOrDefault(key, 0) < mp.get(key)){
                    not = true;
                    break;
                }
            }
            if(not) continue;
            if(s.length() < shortest){
                ans = s;
                shortest = s.length();
            }
        }

        return ans;
    }
}