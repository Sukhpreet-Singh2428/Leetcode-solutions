class Solution {
    public boolean checkOnesSegment(String s) {
        int cnt = 0;
        int occur = 0;

        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(c=='1'){
                cnt++;
            }
            else{
                if(cnt != 0){
                    occur++;
                    if(occur>=2) return false;
                }
                cnt = 0;
            }
        }
        if(cnt!=0){
            occur++;
        }

        if(occur==1) return true;
        return false;
    }
}