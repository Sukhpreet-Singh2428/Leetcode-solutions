class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt = 0;

        int[] freq = new int[3];

        int l = 0;
        int r = 0;

        for(int i=0; i<n; i++){
            char c = s.charAt(i);

            if(c=='a' || c=='b' || c=='c'){
                freq[c-'a']++;
            }

            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                cnt += n-i;
                freq[s.charAt(l)-'a']--;
                l++;
            }

            r++;
        }

        return cnt;
    }
}