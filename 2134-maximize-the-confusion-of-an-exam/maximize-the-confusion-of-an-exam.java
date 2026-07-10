class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();

        int l = 0;
        int r = 0;
        int maxLen = 0;
        int maxf = 0;
        int[] hash = new int[26];

        while(r < n){
            hash[answerKey.charAt(r) - 'A']++;
            maxf = Math.max(maxf, hash[answerKey.charAt(r) - 'A']);

            while( (r-l+1)-maxf > k ){
                hash[answerKey.charAt(l) - 'A']--;
                maxf = 0;
                for(int i=0; i<26; i++){
                    maxf = Math.max(maxf, hash[i]);
                }
                l++;
            }

            if( (r-l+1) - maxf <= k ){
                maxLen = Math.max(maxLen, r-l+1);
            }

            r++;
        }

        return maxLen;
    }
}