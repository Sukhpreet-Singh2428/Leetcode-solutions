class Solution {
    public static void subsets(int idx, int Or, int[] maxOr, int[] cnt, int[] nums, int n){
        if(idx == n){
            if(Or > maxOr[0]){
                maxOr[0] = Or;
                cnt[0] = 1;
            }
            else if(Or == maxOr[0]){
                cnt[0] = cnt[0]+1;
            }
            return;
        }
        
        subsets(idx+1, Or | nums[idx], maxOr, cnt, nums, n);

        subsets(idx+1, Or, maxOr, cnt, nums, n);
    }
    public int countMaxOrSubsets(int[] nums) {
        int[] maxOr = new int[1];
        maxOr[0] = 0;
        int[] cnt = new int[1];
        subsets(0, 0, maxOr, cnt, nums, nums.length);
        return cnt[0];
    }
}