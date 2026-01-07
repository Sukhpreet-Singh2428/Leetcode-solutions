class Solution {
    public static int[] toBinary(int n){
        Stack<Integer> st = new Stack<>();
        while(n>0){
            int d = n%2;
            st.push(d);
            n = n/2;
        }
        int[] ans = new int[st.size()];
        int i=0;
        while(!st.isEmpty()){
           ans[i] = st.pop();
           i++;
        }
        return ans;
    }
    public static int toDecimal(int[] arr){
        int res = 0;
        int converter = 1;
        for(int i=arr.length-1; i>=0; i--){
            res += arr[i]*converter;
            converter *= 2;
        }
        return res;
    }
    public int findComplement(int num) {
        int[] arr = toBinary(num);

        for(int i=0; i<arr.length; i++){
            if(arr[i]==0){
                arr[i] = 1;
            }
            else{
                arr[i] = 0;
            }
        }

        int ans = toDecimal(arr);
        return ans;
    }
}