class Solution {
    public List<Integer> findValidElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<nums[i]){
                st.pop();
            }
            if(!st.isEmpty() && nums[i]==st.peek()) nge[i] = -1;
            else nge[i] = st.isEmpty() ? nums[i] : st.peek();
            st.push(nums[i]);
        }

        Stack<Integer> st1 = new Stack<>();
        int[] pge = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            while(!st1.isEmpty() && st1.peek()<nums[i]){
                st1.pop();
            }
            if(!st1.isEmpty() && nums[i]==st1.peek()) pge[i] = -1;
            else pge[i] = st1.isEmpty() ? nums[i] : st1.peek();
            st1.push(nums[i]);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]==nge[i] || nums[i]==pge[i]){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}