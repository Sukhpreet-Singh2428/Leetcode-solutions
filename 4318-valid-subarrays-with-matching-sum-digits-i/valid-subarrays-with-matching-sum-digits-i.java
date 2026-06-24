class Solution {
    public int func(long num, int x){
        if(num==0 && x==0) return 1;
        long last = -1;
        long first = -1;
        while(num != 0){
            if(last==-1) last = num%10;
            first = num%10;
            num = num/10;
        }

        if(last==x && first==x) return 1;
        return 0;
    }
    public int countValidSubarrays(int[] nums, int x) {
        int cnt = 0;

        for(int i=0; i<nums.length; i++){
            long sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                cnt += func(sum, x);
            }
        }

        return cnt;
    }
}