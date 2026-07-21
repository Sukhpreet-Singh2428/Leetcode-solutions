class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int preSum = 0;
        int maxLen = 0;

        for(int i=0; i<n; i++){
            if(nums[i]==0) preSum -= 1;
            else preSum += 1;

            if(preSum == 0){
                maxLen = Math.max(maxLen, i+1);
            }

            int rem = preSum;
            if(mp.containsKey(rem)){
                int len = i-mp.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            else{
                mp.put(preSum, i);
            }
        }

        return maxLen;
    }
}