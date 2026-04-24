class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int ans = 0;
        
        int l = 0;
        int r = 0;
        for(int i=0; i<moves.length(); i++){
            char c = moves.charAt(i);
            if(c=='L') l++;
            else if(c=='R') r++;
        }

        boolean flag = l>=r ? true : false;
        char space = flag ? 'L' : 'R';

        for(int i=0; i<moves.length(); i++){
            char c = moves.charAt(i);
            if(c==space || c=='_'){
                ans++;
            }
            else{
                ans--;
            }
        }

        return Math.abs(ans);
    }
}