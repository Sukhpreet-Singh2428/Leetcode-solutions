class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int altitue = 0;

        for(int i=0; i<gain.length; i++){
            altitue = gain[i] + altitue;
            ans = Math.max(ans, altitue);
        }

        return ans;
    }
}