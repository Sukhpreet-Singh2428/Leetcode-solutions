class Solution {
    public int smallestNumber(int n) {
        if(n==0) return 1;
        int x = n;
        int pos = 0;

        while(x != 0){
            if((x&1)==0){
                n = n | (1<<pos);
            }
            x = x>>1;
            pos++;
        }

        return n;
    }
}