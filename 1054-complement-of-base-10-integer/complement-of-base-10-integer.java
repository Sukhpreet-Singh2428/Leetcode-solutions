class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int num = 0;
        int len = 0;
        while(n != 0){
            num = num<<1;
            num = num | ((n&1) ^ 1);
            n = n>>1;
            len++;
        }

        // reverse
        int ans = 0;
        for(int i=0; i<len; i++){
            ans = ans<<1;
            ans = ans | (num&1);
            num = num>>1;
        }

        return ans;
    }
}