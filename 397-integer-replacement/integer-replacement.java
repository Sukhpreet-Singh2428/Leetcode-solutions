class Solution {
    public static void func(int cnt, long num, int[] ans){
        if(num==1){
            ans[0] = Math.min(ans[0], cnt);
            return;
        }
        if(cnt > ans[0]){
            return;
        }
        
        if(num%2==0){
            func(cnt+1, num/2, ans);
        }
        else{
            func(cnt+1, num-1, ans);
            func(cnt+1, num+1, ans);
        }
    }
    public int integerReplacement(int n) {
        if(n==1) return 0;
        
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        long num = n;
        
        func(0, num, ans);
        
        return ans[0]==Integer.MAX_VALUE ? -1 : ans[0];
    }
}