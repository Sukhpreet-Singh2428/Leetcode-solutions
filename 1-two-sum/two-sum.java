class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = {-1, -1};
        for(int i=0; i<n; i++){
            int x = target - nums[i]; 
            if(mp.containsKey(x)){
                ans[0] = mp.get(x);
                ans[1] = i; 
            }
            mp.put(nums[i], i);
        }
        return ans;
    }
}