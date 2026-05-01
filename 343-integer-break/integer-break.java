class Solution {
    public static void func(int curr, int n, int sum, int maxSum, int[] maxi, int prod, int cnt){
        if(sum==maxSum){
            if(cnt<2) return;
            maxi[0] = Math.max(maxi[0], prod);
            return;
        }
        if(sum>maxSum){
            return;
        }
        if(curr>n){
            return;
        }
        if(cnt>5 && prod==1){
            return;
        }

        sum += curr;
        prod *= curr;
        cnt += 1;
        func(curr, n, sum, maxSum, maxi, prod, cnt);
        sum -= curr;
        prod /= curr;
        cnt -= 1;
        func(curr+1, n, sum, maxSum, maxi, prod, cnt);
    }
    public int integerBreak(int n) {
        int[] maxi = new int[1];
        func(1, n, 0, n, maxi, 1, 0);
        return maxi[0];
    }
}