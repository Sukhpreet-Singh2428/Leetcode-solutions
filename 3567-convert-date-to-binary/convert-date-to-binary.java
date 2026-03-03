class Solution {
    public static String decToBin(int n){
        StringBuilder ans = new StringBuilder();
        while(n != 0){
            ans.append(n%2);
            n = n/2;
        }
        return ans.reverse().toString();
    }
    public String convertDateToBinary(String date) {
        StringBuilder ans = new StringBuilder();
        int num = 0;
        for(int i=0; i<date.length(); i++){
            char c = date.charAt(i);
            if(c == '-'){
                ans.append(decToBin(num));
                ans.append(c);
                num = 0;
            }
            else{
                num = num*10 + (c-'0');
            }
        }
        ans.append(decToBin(num));

        return ans.toString();
    }
}