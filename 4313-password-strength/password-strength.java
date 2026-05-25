class Solution {
    public int passwordStrength(String password) {
        HashSet<Character> st = new HashSet<>();
        for(int i=0; i<password.length(); i++){
            st.add(password.charAt(i));
        }

        int ans = 0;
        for(char x : st){
            if(x>='a' && x<='z') ans += 1;
            else if(x>='A' && x<='Z') ans += 2;
            else if(x>='0' && x<='9') ans += 3;
            else ans += 5;
        }

        return ans;
    }
}