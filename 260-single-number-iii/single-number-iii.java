class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;

        long XOR_all = 0;
        for(int i=0; i<n; i++){
            XOR_all = XOR_all ^ nums[i];
        }

        int rightmost = (int)(XOR_all & (XOR_all-1)) ^ (int)(XOR_all);
        int b1 = 0;
        int b2 = 0;
        for(int i=0; i<n; i++){
            if((rightmost & nums[i]) != 0){
                b1 = b1 ^ nums[i];
            }
            else{
                b2 = b2 ^ nums[i];
            }
        }

        if(b1<b2) return new int[]{b1,b2};
        return new int[]{b2, b1};
    }
}