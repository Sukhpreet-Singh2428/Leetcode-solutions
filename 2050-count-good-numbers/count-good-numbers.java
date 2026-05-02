class Solution {
    //? brute force : generating all using recursion
    // public static void func(int idx, long n, String s, int[] even, int[] prime, int[] cnt){
    //     if(idx==n){
    //         cnt[0]++;
    //         return;
    //     }

    //     if(idx%2==0){
    //         for(int i=0; i<even.length; i++){
    //             func(idx+1, n, s+even[i], even, prime, cnt);
    //         }
    //     }
    //     else{
    //         for(int i=0; i<prime.length; i++){
    //             func(idx+1, n, s+prime[i], even, prime, cnt);
    //         }
    //     }
    // }

    static final long MOD = 1_000_000_007;
    public long power(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
    public int countGoodNumbers(long n) {
        // int[] even = {0, 2, 4, 6, 8};
        // int[] prime = {2, 3, 5, 7};

        // int[] cnt = new int[1];
        // func(0, n, "", even, prime, cnt);
        // return cnt[0];


        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = (power(5, even) * power(4, odd)) % MOD;
        return (int) ans;
    }
}