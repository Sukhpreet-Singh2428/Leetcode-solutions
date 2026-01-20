class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] present = new int[nums.length+1];
        for(int x : nums){
            present[x] = 1;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1; i<present.length; i++){
            if(present[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }
}