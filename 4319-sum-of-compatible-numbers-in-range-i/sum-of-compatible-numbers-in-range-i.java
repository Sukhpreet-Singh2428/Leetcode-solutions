class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int sum = 0;
        int max = n+k;

        for(int i=1; i<=max; i++){
            if(Math.abs(n-i) <= k){
                if( (n&i) == 0 ) sum += i;
            }
        }

        return sum;
    }
}