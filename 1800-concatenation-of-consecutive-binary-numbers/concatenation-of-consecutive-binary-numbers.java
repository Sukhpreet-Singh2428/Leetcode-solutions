class Solution {
    public static int countBit(int n){
        int cnt = 0;
        while(n!=0){
            cnt++;
            n = n>>1;
        }
        return cnt;
    }
    public int concatenatedBinary(int n) {
        long ans = 0;
        for(int i=1; i<=n; i++){
            int k = countBit(i);
            ans = ans<<k;
            ans = ans | i;
            ans = ans%(1000000007);
        }
        ans = ans%(1000000007);

        return (int)ans;   
    }
}