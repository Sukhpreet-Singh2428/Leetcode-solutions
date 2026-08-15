class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = 0;
        int maxLen = 0;
        List<Integer> ls = new ArrayList<>();

        while(r<n){
            if(ls.size()>0 && nums[r]<=ls.get(ls.size()-1)){
                while(ls.size()>0 && nums[r]<=ls.get(ls.size()-1)){
                    ls.remove(0);
                    l++;
                }
            }

            ls.add(nums[r]);

            maxLen = Math.max(maxLen, r-l+1);

            r++;
        }

        return maxLen;
    }
}