class Solution {
    public static boolean prime(int num){
        int cnt = 0;
        for(int i=1; i*i<=num; i++){
            if(num%i==0){
                cnt++;
                if(i != num/i){
                    cnt++;
                }
            }
        }
        return cnt==2;
    }
    public static int countSetBits(int n){
        int cnt = 0;
        while(n != 0){
            cnt += (n&1);
            n = n>>1;
        }
        return cnt;
    }
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i=left; i<=right; i++){
            int setBits = countSetBits(i);
            if(prime(setBits)) ans++;
        }

        return ans;
    }
}