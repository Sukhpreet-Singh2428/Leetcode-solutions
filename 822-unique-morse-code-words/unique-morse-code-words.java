class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mapping = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> st = new HashSet<>();

        for(int i=0; i<words.length; i++){
            String s = words[i];
            StringBuilder str = new StringBuilder();
            for(int j=0; j<s.length(); j++){
                str.append(mapping[s.charAt(j) - 97]);
            }
            st.add(str.toString());
        }

        return st.size();
    }
}