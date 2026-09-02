class Solution {
    public int sumDecoded(long[] nums) {
        long mod = 1_000_000_007L;

        long sum = 0;

        for(int i=0; i<nums.length; i++){
            long num = nums[i];

            int width = (int)(num%10);
            long d = num/10;

            StringBuilder s = new StringBuilder(String.valueOf(d));

            int x = 0;
            for(int j=0; j<width; j++){
                x = x*10 + (s.charAt(j) - '0');
            }
            int y = 0;
            for(int j=width; j<s.length(); j++){
                y = y*10 + (s.charAt(j) - '0');
            }

            // POW
            long value = 1;
            long base = x;
            while(y>0){
                if(y%2==1){
                    value = (value*base)%mod;
                }

                base = (base * base)%mod;
                y /= 2;
            }

            sum = (sum + value)%mod;
        }

        return (int)sum;
    }
}