class Solution {
    public boolean canAliceWin(int n) {
        if(n<10) return false;

        int alice = 10;
        int bob = 9;

        int temp = n;
        while(temp >= alice){
            temp = temp - alice;
            if(temp < bob) return true;
            temp = temp - bob;

            alice = bob-1;
            bob = alice-1;
        }

        return false;
    }
}