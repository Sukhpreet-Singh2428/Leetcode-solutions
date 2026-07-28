class Solution {
    public int digitSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }
    public int largestInteger(int n, int s) {
        if(s==0) return 0;

        int start = 1;
        for(int i=2; i<=n; i++){
            start *= 10;
        }

        int end = start*10 - 1;

        for(int i=end; i>=start; i--){
            if(digitSum(i) == s){
                return i; 
            }
        }

        return -1;
    }
}