class Solution {
    public static int[] findNGE(int[] nums){
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }
    public static int[] findNSE(int[] nums){
        int n = nums.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    public static int[] findPGE(int[] nums){
        int n = nums.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }
    public static int[] findPSE(int[] nums){
        int n = nums.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
    public static long sumOfSubarrayMaximum(int[] nums){
        int n = nums.length;
        int[] nge = findNGE(nums);
        int[] pge = findPGE(nums);
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            int left = i - pge[i];
            int right = nge[i] - i;
            sum += (long) left * right * nums[i];
        }
        return sum;
    }
    public static long sumOfSubarrayMinimum(int[] nums){
        int n = nums.length;
        int[] nse = findNSE(nums);
        int[] pse = findPSE(nums);
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            sum += (long) left * right * nums[i];
        }
        return sum;
    }
    public long subArrayRanges(int[] nums) {
        return sumOfSubarrayMaximum(nums) - sumOfSubarrayMinimum(nums);
    }
}