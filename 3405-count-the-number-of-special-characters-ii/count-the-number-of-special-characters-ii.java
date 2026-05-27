class pair{
    boolean exist;
    int idx;

    public pair(boolean exist, int idx){
        this.exist = exist;
        this.idx = idx;
    }
}
class Solution {
    public int numberOfSpecialChars(String word) {
        pair[] check = new pair[256];
        Arrays.fill(check, new pair(false, -1));

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if((c>='A' && c<='Z') && check[c].exist==true) continue;
            check[c] = new pair(true, i);
        }

        int cnt = 0;
        for(int i=0; i<256; i++){
            if(i+32 < 256){
                if(check[i].exist==true && check[i+32].exist==true){
                    if(check[i].idx > check[i+32].idx) cnt++;
                }
            }
        }

        return cnt;
    }
}