class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num;
        if(num==0 || num==1) return true;
        while(low<=high){
            long mid = low + (high-low)/2;
            long val = mid*mid;
            if(val == num) return true;
            else if(val < num){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}