class Solution {
    public int minimumOperations(int[] nums) {
        int cnt = 0;
        for(int x : nums){
            if(x%3 != 0){
                cnt++;
            }
        }

        return cnt;
    }
}