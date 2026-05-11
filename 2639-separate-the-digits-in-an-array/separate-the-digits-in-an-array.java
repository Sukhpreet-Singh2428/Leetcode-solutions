class Solution {
    public void func(int num, List<Integer> ls){
        if(num<=0){
            return;
        }

        func(num/10, ls);
        ls.add(num%10);
    }
    public int[] separateDigits(int[] nums) {
        List<Integer> ls = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            func(num, ls);
        }

        int[] ans = new int[ls.size()];
        for(int i=0; i<ls.size(); i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}