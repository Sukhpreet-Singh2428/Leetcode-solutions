class Solution {
    public static void subsets(int idx, int[] cnt, HashMap<Integer, Integer> mp, int k, int[] nums, int n){
        if(idx==n){
            if(mp.size() > 0) cnt[0]++;
            return;
        }

        if(!mp.containsKey(nums[idx] - k) && !mp.containsKey(nums[idx] + k)){
            mp.put(nums[idx], mp.getOrDefault(nums[idx], 0)+1);
            subsets(idx+1, cnt, mp, k, nums, n);
            mp.put(nums[idx], mp.get(nums[idx])-1);
            if(mp.get(nums[idx])==0) mp.remove(nums[idx]);
        }

        subsets(idx+1, cnt, mp, k, nums, n);
    }
    public int beautifulSubsets(int[] nums, int k) {
        int[] cnt = new int[1];
        HashMap<Integer, Integer> mp = new HashMap<>();
        subsets(0, cnt, mp, k, nums, nums.length);
        return cnt[0];
    }
}