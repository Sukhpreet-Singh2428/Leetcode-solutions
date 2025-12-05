class Solution {
    public static int sum(int[] nums, int i, int j){
        int ans = 0;
        while(i<=j){
            ans += nums[i];
            i++;
        }
        return ans;
    }
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int left = 0;
        int cnt = 0;
        for(int i=0; i<n-1; i++){
            int val = nums[i];
            left += val;
            int right = sum(nums, i+1, n-1);
            int diff = left - right;
            if(diff < 0) diff = diff*-1;
            if(diff % 2 == 0) cnt++;
        }

        return cnt;
    }
}