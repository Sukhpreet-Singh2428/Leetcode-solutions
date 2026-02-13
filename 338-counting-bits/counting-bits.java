class Solution {
    public static int number_setBits(int x){
        int cnt = 0;
        while(x != 0){
            x = x & (x-1);
            cnt++;
        }
        return cnt;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0; i<=n; i++){
            ans[i] = number_setBits(i);
        }
        return ans;
    } 
}