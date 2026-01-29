class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<chars.length(); i++){
            char c = chars.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }

        int sum = 0;
        for(int i=0; i<words.length; i++){
            String s = words[i];
            HashMap<Character, Integer> freq = new HashMap<>();
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                freq.put(c, freq.getOrDefault(c, 0)+1);
            }
            boolean check = false;
            for(char key : freq.keySet()){
                if(!mp.containsKey(key) || freq.get(key) > mp.get(key)){
                    check = true;
                    break;
                }
            }
            if(check) continue;
            sum += s.length();
        }

        return sum;
    }
}