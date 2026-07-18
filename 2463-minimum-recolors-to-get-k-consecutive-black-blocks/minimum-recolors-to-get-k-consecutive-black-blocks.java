class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        int l = 0;
        int r = 0;
        int minNum = Integer.MAX_VALUE;
        int white = 0;

        while(r < n){
            char c = blocks.charAt(r);
            if(c=='W') white++;

            if(r-l+1 > k){
                char left = blocks.charAt(l);
                if(left=='W') white--;
                l++;
            }

            if(r-l+1 == k){
                minNum = Math.min(minNum, white);
            }

            r++;
        }

        return minNum==Integer.MAX_VALUE ? 0 : minNum;
    }
}