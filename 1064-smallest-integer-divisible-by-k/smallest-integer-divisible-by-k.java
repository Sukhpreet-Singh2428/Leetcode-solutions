class Solution {
    public void func(long num, int len, int[] ans, int k){
        if(num%k==0){
            ans[0] = Math.min(ans[0], len);
            return;
        }

        func((num*10+1)%k, len+1, ans, k);
    }
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0) return -1;
        
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;

        func(1, 1, ans, k);

        return ans[0]==Integer.MAX_VALUE ? -1 : ans[0];
    }
}