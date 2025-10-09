class Solution {
    public static int func(int n){
        int sum = 0;
        while(n>0){
            int d = n%10;
            sum += d*d;
            n /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> st = new HashSet<>();
        while(n!=1 && !st.contains(n)){
            st.add(n);
            n = func(n);
        }
        return n==1;
    }
}