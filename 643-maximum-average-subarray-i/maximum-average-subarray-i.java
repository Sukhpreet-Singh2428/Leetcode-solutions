class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Integer.MIN_VALUE;
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        double sum = 0;
        for(int i=0; i<nums.length; i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                sum -= nums[dq.pollFirst()];
            }
            sum += nums[i];
            dq.offerLast(i);
            if(i>=k-1){
                double avg = sum/k;
                ans = Math.max(ans, avg);
            }
        }

        return ans;
    }
}