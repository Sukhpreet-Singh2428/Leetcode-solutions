class Solution {
    public static void func(int idx, int n, long prod1, long prod2, int[] nums, boolean[] ans, long target){
        if(idx==n){
            if(prod1==prod2 && prod1==target) ans[0] = true;
            return;
        }
        if(ans[0]==true){
            return;
        }
        if(prod1>target || prod2>target){
            return;
        }

        prod1 *= nums[idx];
        func(idx+1, n, prod1, prod2, nums, ans, target);
        prod1 /= nums[idx];
        prod2 *= nums[idx];
        func(idx+1, n, prod1, prod2, nums, ans, target);
        prod2 /= nums[idx];
    }
    public boolean checkEqualPartitions(int[] nums, long target) {
        boolean[] ans = new boolean[1];
        ans[0] = false;

        func(0, nums.length, 1, 1, nums, ans, target);

        return ans[0];
    }
}