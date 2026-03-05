class Solution {
    public static int startWithOne(String s){
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if((i&1)!=1){
                if(c!='1') cnt++;
            }
            else{
                if(c!='0') cnt++;
            }
        }
        return cnt;
    }
    public static int startWithZero(String s){
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if((i&1)!=1){
                if(c!='0') cnt++;
            }
            else{
                if(c!='1') cnt++;
            }
        }
        return cnt;
    }
    public int minOperations(String s) {
        int cnt1 = startWithZero(s);
        int cnt2 = startWithOne(s);

        int ans = Math.min(cnt1, cnt2);
        return ans;
    }
}