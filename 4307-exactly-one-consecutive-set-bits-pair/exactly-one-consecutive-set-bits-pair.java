class Solution {
    public boolean consecutiveSetBits(int n) {
        int x = 0;
        int cnt = 0;
        while(n!=0){
            int bit = (n&1);
            if(x==1){
                if( (bit^x) == 0 ){
                    cnt++;
                    if(cnt>1) return false;
                } 
            }

            x=bit;
            n = n>>1;
        }

        return cnt==1;
    }
}