class Solution {

    public int atMost(int[] nums, int k){
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>();

        int l = 0;
        int cnt = 0;

        for(int r=0; r<n; r++){
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);

            while(mp.size() > k){
                mp.put(nums[l], mp.get(nums[l]) - 1);
                if(mp.get(nums[l]) == 0){
                    mp.remove(nums[l]);
                }
                l++;
            }

            cnt += (r - l + 1);
        }

        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}