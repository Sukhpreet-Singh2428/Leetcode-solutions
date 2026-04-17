class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<num.length(); i++){
            while(!st.isEmpty() && k>0 && st.peek()-'0' > num.charAt(i)-'0'){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k > 0){
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans.reverse();
        int j = 0;
        while(j<ans.length() && ans.charAt(j)=='0'){
            j++;
        }
        if(j==ans.length()) return "0";

        return ans.substring(j).toString();
    }
}