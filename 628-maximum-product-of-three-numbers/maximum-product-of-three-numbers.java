class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;

        int ans = Integer.MIN_VALUE;
        int maxi = -1001;
        int smaxi = -1001;
        int mini = 1001;
        int smini = 1001;

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(maxi!=-1001 && smaxi!=-1001) ans = Math.max(ans, num*maxi*smaxi);

            if(num == maxi){
                smaxi = num;
            }
            else if(num > maxi){
                smaxi = maxi;
                maxi = num;
            }
            else if(num > smaxi && num != maxi){
                smaxi = num;
            }

            if(num==mini){
                smini = num;
            }
            else if(num < mini){
                smini = mini;
                mini = num;
            }
            else if(num < smini && num != mini){
                smini = num;
            }
        }

        ans = Math.max(ans, mini*smini*maxi);

        return ans;
    }
}