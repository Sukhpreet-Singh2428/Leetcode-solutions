class Solution {
    public int gcd(int n1, int n2){
        int ans = 1;

        for(int i=Math.min(n1, n2); i>=0; i--){
            if(n1%i==0 && n2%i==0){
                ans = i;
                break;
            }
        }

        return ans;
    }
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;

        for(int i=1; i<=2*n; i++){
            if(i%2==1) sumOdd += i;
            else sumEven += i;
        }

        return gcd(sumOdd, sumEven);
    }
}