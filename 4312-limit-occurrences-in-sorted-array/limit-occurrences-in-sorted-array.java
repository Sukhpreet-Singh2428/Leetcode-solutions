class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> ls = new ArrayList<>();

        int cnt = 0;
        int curr = nums[0];
        for(int i=0; i<nums.length; i++){
            if(curr != nums[i]){
                curr = nums[i];
                cnt = 0;
            }
            if(curr==nums[i] && cnt<k){
                ls.add(nums[i]);
                cnt++;
            }
        }

        int[] ans = new int[ls.size()];
        for(int i=0; i<ls.size(); i++){
            ans[i] = ls.get(i);
        }

        return ans;
    }
}