class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder s = new StringBuilder();

        for(int i=0; i<words.length; i++){
            String word = words[i];
            int sum = 0;
            for(int j=0; j<word.length(); j++){
                char c = word.charAt(j);
                sum += weights[c-'a'];
            }
            sum = sum%26;
            s.append((char)('z' - sum));
        }

        return s.toString();
    }
}