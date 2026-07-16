class Solution {
    public int gcd(int a, int b){
        while(a!=0 && b!=0){
            if(a>b) a = a%b;
            else b = b%a;
        }
        if(a==0) return b;
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;

        int maxi = Integer.MIN_VALUE;
        int[] prefixGcd = new int[n];

        for(int i=0; i<n; i++){
            maxi = Math.max(maxi, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxi);
        }
        Arrays.sort(prefixGcd);

        long sum = 0;
        int i = 0;
        int j = n-1;

        while(i<j){
            sum += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }

        return sum;
    }
}