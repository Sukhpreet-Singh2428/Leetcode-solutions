class Solution {
    public int sum(int num){
        int ans = 0;
        while(num != 0){
            ans += num%10;
            num = num/10;
        }
        return ans;
    }
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            ans = Math.min(ans, sum(nums[i]));
        }

        return ans;
    }
}