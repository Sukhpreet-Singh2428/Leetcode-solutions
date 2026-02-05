class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] ans = new int[nums.length];

        int i = 0;
        while(i<ans.length){
            int val = nums[i];
            int x = i+val;
            x = x%ans.length;
            if(x<0){
                x += ans.length;
            }
            ans[i] = nums[x];

            i++;
        }

        return ans;
    }
}