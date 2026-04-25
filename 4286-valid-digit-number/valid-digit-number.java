class Solution {
    public boolean validDigit(int n, int x) {
        boolean ans = false;
        int last = -1;
        while(n>0){
            int d = n%10;
            if(d==x) ans = true;
            last = d;
            n = n/10;
        }
        if(last==x) return false;

        return ans;
    }
}