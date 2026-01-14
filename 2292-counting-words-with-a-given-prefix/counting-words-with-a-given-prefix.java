class Solution {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for(int i=0; i<words.length; i++){
            String s = words[i];
            if(s.length()<pref.length()) continue;
            int j=0;
            while(j<pref.length() && s.charAt(j)==pref.charAt(j)){
                j++;
            }
            if(j==pref.length()) cnt++;
        }

        return cnt;
    }
}