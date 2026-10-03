class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int i=0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        int idx = 0;
        while(mp.size() > 0){
            int start = idx;
            for(int key : mp.keySet()){
                ans[idx] = key;
                idx++;
            }
            for(int i=start; i<idx; i++){
                int key = ans[i];
                mp.put(key, mp.getOrDefault(key, 0)-1);
                if(mp.get(key) <= 0) mp.remove(key);
            }
        }

        return ans;
    }
}