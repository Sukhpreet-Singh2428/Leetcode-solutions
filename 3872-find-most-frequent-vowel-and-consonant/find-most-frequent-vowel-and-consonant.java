class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            freq[c-97]++;
        }

        int maxV = 0;
        int maxC = 0;
        for(int i=0; i<26; i++){
            if((char)(i+97)=='a' || (char)(i+97)=='e' || (char)(i+97)=='i' || (char)(i+97)=='o' || (char)(i+97)=='u'){
                maxV = Math.max(maxV, freq[i]);
            }
            else{
                maxC = Math.max(maxC, freq[i]);
            }
        }   

        return maxV+maxC;
    }
}