class Solution {
    StringBuilder ans;
    int cnt;
    public void func(int[] nums, List<Integer> ls, List<Boolean> seen, int k){
        if(ls.size() == nums.length){
            cnt++;
            if(cnt==k){
                for(int x : ls){
                    ans.append(x);
                }
            }
            return;
        }
        if(cnt>=k){
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(seen.get(i)==false){
                seen.set(i, true);
                ls.add(nums[i]);
                func(nums, ls, seen, k);
                ls.remove(ls.size()-1);
                seen.set(i, false);
            }
        }
    }
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i=1; i<=n; i++){
            nums[i-1] = i;
        }
        List<Integer> ls = new ArrayList<>();
        List<Boolean> seen = new ArrayList<>();
        for(int i=0; i<n; i++){
            seen.add(false);
        }

        ans = new StringBuilder();
        cnt = 0;

        func(nums, ls, seen, k);

        return ans.toString();
    }
}