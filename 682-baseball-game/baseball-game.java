class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<operations.length; i++){
            String s = operations[i];
            if(s.equals("C")){
                st.pop();
            }
            else if(s.equals("D")){
                st.push(st.peek() * 2);
            }
            else if(s.equals("+")){
                int temp = st.pop();
                int x = temp + st.peek();
                st.push(temp);
                st.push(x);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }

        int sum = 0;
        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}