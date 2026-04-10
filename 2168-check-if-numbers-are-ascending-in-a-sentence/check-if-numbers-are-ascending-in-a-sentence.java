class Solution {
    public boolean areNumbersAscending(String s) {
        int i = 0;
        int n = s.length();
        int prev = -1;
        while(i<n){
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                int num = c-'0';
                while(i+1<n && s.charAt(i+1)>='0' && s.charAt(i+1)<='9'){
                    num = num*10 + s.charAt(i+1) - '0';
                    i++;
                }
                if(prev==-1){
                    prev = num;
                }
                else{
                    if(prev >= num) return false;
                    prev = num;
                }
            }
            i++;
        }

        return true;
    }
}