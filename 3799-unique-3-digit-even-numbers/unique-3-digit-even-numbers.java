class Solution {
    public void func(int digit, int len, int[] digits, boolean[] vis, HashSet<Integer> st){
        if(len == 3){
            if(digit%2==0) st.add(digit);
            return;
        }
        for(int i=0; i<digits.length; i++){
            if(vis[i] == false){
                vis[i] = true;
                func(digit*10+digits[i], len+1, digits, vis, st);
                vis[i] = false;
            }
        }
    }
    public int totalNumbers(int[] digits) {
        int n = digits.length;

        boolean[] vis = new boolean[n];
        HashSet<Integer> st = new HashSet<>();

        for(int i=0; i<n; i++){
            if(digits[i]!=0){
                vis[i] = true;
                func(digits[i], 1, digits, vis, st);
                vis[i] = false;
            }
        }

        return st.size();
    }
}