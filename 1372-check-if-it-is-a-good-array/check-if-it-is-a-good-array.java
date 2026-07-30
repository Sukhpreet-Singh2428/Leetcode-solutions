class Solution {
    public int func(int a, int b){
        while(a!=0 && b!=0){
            if(a>b) a = a%b;
            else b = b%a;
        }
        if(a==0) return b;
        return a;
    }
    public boolean isGoodArray(int[] nums) {
        int gcd = nums[0];
        if(gcd == 1) return true;

        for(int i=1; i<nums.length; i++){
            gcd = func(gcd, nums[i]);
            if(gcd == 1){
                return true;
            }
        }

        return gcd==1;
    }
}