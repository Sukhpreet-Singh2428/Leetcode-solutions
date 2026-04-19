class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ls = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<nums.length; i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i >= k-1){
                ls.add(nums[dq.peekFirst()]);
            }
        }

        int[] ans = new int[ls.size()];
        for(int i=0; i<ls.size(); i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}