class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if(k==n){
            int ans = -1;
            for(int x : nums){
                ans = Math.max(ans, x);
            }
            return ans;
        }
        
        HashMap<Integer, Integer> mp = new HashMap<>();

        int l = 0;
        int r = 0;
        while(r < n){
            if(r-l+1 > k){
                l++;
            }

            if(r-l+1 == k){
                for(int i=l; i<=r; i++){
                    mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
                }
            }

            r++;
        }

        int ans = -1;
        for(int key : mp.keySet()){
            if(mp.get(key) == 1){
                ans = Math.max(ans, key);
            }
        }

        return ans;
    }
}