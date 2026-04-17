class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] occur = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            occur[c-'a'] = i;
        }

        int sum = 0;
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            sum += Math.abs(i - occur[c-'a']);
        }

        return sum;
    }
}