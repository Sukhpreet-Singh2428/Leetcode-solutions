class Solution {
    public int binaryGap(int n) {
        int ans = 0;
        int cnt = 0;
        while(n!=0){
            int d = (n&1);
            if(d==1){
                cnt = 1;
                n = n>>1;
                while((n&1)!=1 && n!=0){
                    cnt++;
                    n = n>>1;
                }
                if((n&1)==1) ans = Math.max(ans, cnt);
            }
            else{
                n = n>>1;
            }
        }

        return ans;
    }
}