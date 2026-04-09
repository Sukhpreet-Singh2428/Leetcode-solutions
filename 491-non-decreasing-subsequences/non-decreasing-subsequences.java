class Solution {
    public static void func(int idx, int[] nums, List<Integer> ls, Set<List<Integer>> ans){
        if(idx==nums.length){
            if(ls.size() >= 2) ans.add(new ArrayList<>(ls));
            return;
        }
        if(ls.size()>0 && ls.get(ls.size()-1) > nums[idx]){
            func(idx + 1, nums, ls, ans);
            return;
        }
        
        ls.add(nums[idx]);
        func(idx+1, nums, ls, ans);
        ls.remove(ls.size()-1);
        func(idx+1, nums, ls, ans);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> ls = new ArrayList<>();
        func(0, nums, ls, ans);

        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> v : ans){
            res.add(v);
        }
        return res;
    }
}