class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        int l = 0;
        int r = 0;
        double sum = 0;
        double avg = Integer.MIN_VALUE;

        while(r < n){
            sum += nums[r];

            if(r-l+1 > k){
                sum -= nums[l];
                l++;
            }

            if(r-l+1 == k){
                double average = sum/(double)k;
                avg = Math.max(avg, average);
            }
            
            r++;
        }

        return avg;
    }
}