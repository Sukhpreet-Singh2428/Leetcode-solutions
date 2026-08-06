class Solution {
    public int func(int num){
        int prod = 1;
        while(num != 0){
            prod = prod*(num%10);
            num = num/10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        int ans = n;

        for(int i=n; i<=100; i++){
            int prod = func(i);
            if(prod%t==0){
                ans = i;
                break;
            }
        }

        return ans;
    }
}