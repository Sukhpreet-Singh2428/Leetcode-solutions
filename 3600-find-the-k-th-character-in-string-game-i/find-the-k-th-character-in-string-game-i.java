class Solution {
    public static void func(StringBuilder s, int k){
        if(s.length() >= k){
            return;
        }

        StringBuilder extra = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='z'){
                extra.append('a');
            }
            else{
                extra.append((char)(c+1));
            }
        }

        s.append(extra);
        func(s, k);

    }
    public char kthCharacter(int k) {
        StringBuilder s = new StringBuilder();
        s.append("a");
        func(s, k);

        return s.charAt(k-1);
    }
}