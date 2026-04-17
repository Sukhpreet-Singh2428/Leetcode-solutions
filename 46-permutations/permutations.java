class Solution {
    public void func(List<List<Integer>> ans, List<Integer> ls, int[] freq, int[] nums){
        if(ls.size() == nums.length){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(freq[i]==0){
                ls.add(nums[i]);
                freq[i] = 1;
                func(ans, ls, freq, nums);
                ls.remove(ls.size()-1);
                freq[i] = 0;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        int[] freq = new int[nums.length];
        func(ans, ls, freq, nums);
        return ans;
    }
}