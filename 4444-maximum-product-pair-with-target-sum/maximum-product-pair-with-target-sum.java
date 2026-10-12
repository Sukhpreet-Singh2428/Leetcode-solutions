class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            mp.put(nums[i], i);
        }

        int ans = Integer.MIN_VALUE;
        int p = -1;
        int q = -1;
        for(int i=0; i<n; i++){
            int diff = target - nums[i];
            if(mp.containsKey(diff) && nums[i] > nums[mp.get(diff)]){
                if(nums[i]*diff > ans){
                    ans = nums[i]*diff;
                    p = i;
                    q = mp.get(diff);
                }
            }
        }

        return new int[]{p, q};
    }
}