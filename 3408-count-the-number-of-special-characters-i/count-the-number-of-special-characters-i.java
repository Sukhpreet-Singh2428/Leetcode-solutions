class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] check = new boolean[256];
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            check[c] = true;
        }

        int cnt = 0;
        for(int i=0; i<256; i++){
            if(i+32 < 256){
                if(check[i]==true && check[i+32]==true){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}