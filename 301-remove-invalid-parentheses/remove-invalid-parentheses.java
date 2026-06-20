class Solution {
    int bestLen = -1;
    public void func(int idx, char[] arr, String s, Set<String> ls, Stack<Character> st){
        if(idx==arr.length){
           if(st.isEmpty()){
                if(bestLen==-1){
                    bestLen = s.length();
                }
                if(s.length() == bestLen){
                    ls.add(s);
                }
           }
            return;
        }
        if(s.length() + (arr.length - idx) < bestLen){
            return;
        }

        char c = arr[idx];
        if(c==')'){
            if(st.isEmpty()){
                func(idx+1, arr, s, ls, st);
            }

            else if(st.peek()=='('){
                char temp = st.pop();
                func(idx+1, arr, s+c, ls, st);
                st.push(temp);
                func(idx+1, arr, s, ls, st);
            }
            else{
                func(idx+1, arr, s, ls, st);
            }
        }
        else{
            if(c>='a' && c<='z'){
                func(idx+1, arr, s+c, ls, st);
            }
            else{
                st.push(c);
                func(idx+1, arr, s+c, ls, st);
                if(!st.isEmpty()) st.pop();
                func(idx+1, arr, s, ls, st);
            }
        }

    }
    public List<String> removeInvalidParentheses(String s) {
        char[] arr = s.toCharArray();

        Set<String> ls = new HashSet<>();
        Stack<Character> st = new Stack<>();
        func(0, arr, "", ls, st);

        List<String> ans = new ArrayList<>();
        for(String str : ls){
            ans.add(str);
        }

        return ans;
    }
}