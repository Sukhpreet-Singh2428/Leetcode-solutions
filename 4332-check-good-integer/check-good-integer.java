class Solution {
    public boolean checkGoodInteger(int n) {
        long sum = 0;
        long squareSum = 0;

        while(n!=0){
            int d = n%10;
            sum += d;
            squareSum += d*d;
            n = n/10;
        }

        long ans = squareSum - sum;
        if(ans >= 50) return true;
        return false;
    }
}