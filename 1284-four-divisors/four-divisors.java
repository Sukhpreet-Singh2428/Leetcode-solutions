class Solution {
    public static int divisors(int num){
        int cnt = 0;
        int sum = 0;
        for(int i=1; i*i<=num; i++){
            if(num%i==0){
                cnt++;
                sum += i;
                if(num/i != i){
                    cnt++;
                    sum += num/i;
                }
            }
        }

        if(cnt != 4) return -1;
        return sum;
    }
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            int x = divisors(nums[i]);
            if(x != -1) ans += x;
        }

        return ans;
    }
}