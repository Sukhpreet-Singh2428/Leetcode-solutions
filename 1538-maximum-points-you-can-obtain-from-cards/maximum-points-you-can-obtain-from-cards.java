class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int maxSum = -1;
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += cardPoints[i];
        }
        maxSum = sum;

        int rIdx = n-1;
        for(int i=k-1; i>=0; i--){
            sum = sum - cardPoints[i];
            sum = sum + cardPoints[rIdx];
            maxSum = Math.max(sum, maxSum);
            rIdx--;
        }

        return maxSum;
    }
}