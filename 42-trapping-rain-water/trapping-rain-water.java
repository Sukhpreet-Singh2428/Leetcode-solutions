class Solution {
    public int[] prefixMax(int[] height, int n){
        int[] preMax = new int[n];
        preMax[0] = height[0];
        for(int i=1; i<n; i++){
            preMax[i] = Math.max(preMax[i-1], height[i]);
        }
        return preMax;
    }
    public int[] suffixMax(int[] height, int n){
        int[] sufMax = new int[n];
        sufMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            sufMax[i] = Math.max(sufMax[i+1], height[i]);
        }
        return sufMax;
    }
    public int trap(int[] height) {
        int n = height.length;

        int[] leftMax = prefixMax(height, n);
        int[] rightMax = suffixMax(height, n);

        int total = 0;
        for(int i=0; i<n; i++){
            if(height[i]<leftMax[i] && height[i]<rightMax[i]){
                total += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }

        return total;
    }
}