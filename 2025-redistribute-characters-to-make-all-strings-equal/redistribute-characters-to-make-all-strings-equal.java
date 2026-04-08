class Solution {
    public boolean makeEqual(String[] words) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<words.length; i++){
            String s = words[i];
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                mp.put(c, mp.getOrDefault(c, 0)+1);
            }
        }

        for(char key : mp.keySet()){
            int freq = mp.get(key);
            if(freq%words.length != 0) return false;
        }

        return true;
    }
}