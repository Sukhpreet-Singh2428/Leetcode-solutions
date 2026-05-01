class Solution {
    public static String invert(String s){
        StringBuilder ans = new StringBuilder("");
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='0') ans.append('1');
            else ans.append('0');
        }
        return ans.toString();
    }
    public static String reverse(String s){
        StringBuilder ans = new StringBuilder(s);
        ans.reverse();
        return ans.toString();
    }
    public static void func(int i, int n, String s, String[] last){
        if(i>n){
            return;
        }
        if(i==1){
            s = "0";
            last[0] = "0";
            func(i+1, n, s, last);
        }
        else{
            s = last[0] + "1" + reverse(invert(last[0]));
            last[0] = s;
            func(i+1, n, s, last);
        }
    }
    public char findKthBit(int n, int k) {
        String[] last = new String[1];
        func(1, n, "", last);
        return last[0].charAt(k-1);
    }
}