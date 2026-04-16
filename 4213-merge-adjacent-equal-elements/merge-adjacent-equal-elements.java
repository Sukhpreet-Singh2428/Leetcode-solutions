class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();

        for(int i=0; i<nums.length; i++){
            long num = nums[i];
            if(st.isEmpty()){
                st.push(num);
            }
            else{
                // long x = st.peek();

                if(st.peek()==num){
                    long x = st.peek();
                    while(!st.isEmpty() && st.peek()==x){
                        st.pop();
                        x = x*2;
                    }
                    st.push(x);
                }

                // if(x==num){
                //     x += st.pop();
                //     st.push(x);
                // }
                else{
                    st.push(num);
                }
            }
        }

        List<Long> ls = new ArrayList<>();
        while(!st.isEmpty()){
            ls.add(st.pop());
        }
        Collections.reverse(ls);

        return ls;
    }
}