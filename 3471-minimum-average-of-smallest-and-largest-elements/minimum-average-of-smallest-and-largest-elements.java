class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        List<Double> arr = new ArrayList<>();
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            double sum = nums[i] + nums[j];
            arr.add(sum/2);
            i++;
            j--;
        }

        double mini = Double.MAX_VALUE;
        for(int k=0; k<arr.size(); k++){
            mini = Math.min(mini, arr.get(k));
        }

        return mini;
    }
}