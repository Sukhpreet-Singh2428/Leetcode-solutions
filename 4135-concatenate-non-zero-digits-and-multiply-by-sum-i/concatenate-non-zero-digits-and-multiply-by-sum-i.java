class Solution {
    public long sumAndMultiply(int n) {
        long nonZero = 0;
        while(n > 0){
            if(n%10 != 0){
                nonZero = nonZero*10 + n%10;
            }
            n = n/10;
        }
        long ans = 0;
        long sum = 0;
        while(nonZero > 0){
            sum += nonZero%10;
            ans = ans*10 + nonZero%10;
            nonZero = nonZero/10;
        }

        return ans*sum;
    }
}