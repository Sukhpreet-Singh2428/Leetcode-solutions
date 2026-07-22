class Solution {
    public char findTheDifference(String s, String t) {
        // HashMap<Character, Integer> mp = new HashMap<>();
        int[] hash = new int[26];

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            // mp.put(c, mp.getOrDefault(c, 0)+1);
            hash[c-'a']++;
        }

        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            // mp.put(c, mp.getOrDefault(c, 0)-1);
            hash[c-'a']--;
        }

        // for(char key : mp.keySet()){
        //     if(mp.get(key) < 0){
        //         return key;
        //     }
        // }

        for(int i=0; i<26; i++){
            if(hash[i] < 0){
                return (char)(i + 'a');
            }
        }

        return '1';
    }
}