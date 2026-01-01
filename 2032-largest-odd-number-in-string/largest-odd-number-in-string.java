class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int j = -1;
        for(int i=n-1; i>=0; i--){
            char s = num.charAt(i);
            if( (s - '0')%2 == 1 ){
                j = i;
                break;
            }
        }

        if(j==-1){
            return "";
        }

        int i = 0;
        while(i<n){
            if(num.charAt(i) != '0'){
                break;
            }
            i++;
        }

        return num.substring(i, j+1);
    }
}