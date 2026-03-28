class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        ArrayList<Integer> ls = new ArrayList<>();
        for(int x : nums){
            ls.add(x);
        }

        Collections.sort(ls);
        
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = ls.indexOf(nums[i]);
        }

        return ans;
    }
}