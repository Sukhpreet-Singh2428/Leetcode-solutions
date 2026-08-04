class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int maxi = nums[0];
        int mini = nums[0];
        HashSet<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
            mini = Math.min(mini, nums[i]);
            st.add(nums[i]);
        }

        List<Integer> ls = new ArrayList<>();
        for(int i=mini; i<=maxi; i++){
            if(!st.contains(i)){
                ls.add(i);
            }
        }

        return ls;
    }
}