class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        int n = nums.length;
        HashSet<Integer> st = new HashSet<>();
        for(int x : nums){
            st.add(x);
        }

        List<List<Integer>> ans = new ArrayList<>();
        int start = -1;
        int end = -1;
        
        for(int i=lower; i<=upper; i++){
            if(!st.contains(i) && start==-1){
                start = i;
                end = i;
            }
            else if(st.contains(i) && start!=-1){
                List<Integer> ls = new ArrayList<>();
                ls.add(start);
                ls.add(end);
                ans.add(ls);

                start = -1;
            }
            end = i;
        }
        if(!st.contains(end) && start!=-1){
            List<Integer> ls = new ArrayList<>();
            ls.add(start);
            ls.add(end);
            ans.add(ls);
        }

        return ans;
    }
}