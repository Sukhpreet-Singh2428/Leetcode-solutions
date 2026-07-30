class Solution {
    public int gcd(int a, int b){
        while(a!=0 && b!=0){
            if(a>b) a = a%b;
            else b = b%a;
        }
        if(a==0) return b;
        return a;
    }
    public int commonFactors(int a, int b) {
        int x = gcd(a, b);

        int cnt = 0;
        for(int i=1; i<=x; i++){
            if(a%i==0 && b%i==0) cnt++;
        }

        return cnt;
    }
}