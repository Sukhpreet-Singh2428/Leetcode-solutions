class Solution {
    public int gcd(int a, int b){
        while(a!=0 && b!=0){
            if(a>b) a = a%b;
            else b = b%a;
        }
        if(a==0) return b;
        return a;
    }
    public int findGCD(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int x : nums){
            mini = Math.min(mini, x);
            maxi = Math.max(maxi, x);
        }

        return gcd(mini, maxi);
    }
}