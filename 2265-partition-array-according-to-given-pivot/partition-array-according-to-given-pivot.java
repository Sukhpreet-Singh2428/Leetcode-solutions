class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> ls = new ArrayList<>();

        for(int x : nums){
            if(x<pivot) ls.add(x);
        }

        for(int x : nums){
            if(x==pivot) ls.add(x);
        }

        for(int x : nums){
            if(x>pivot) ls.add(x);
        }

        int[] ans = new int[ls.size()];
        for(int i=0; i<ls.size(); i++){
            ans[i] = ls.get(i);
        }

        return ans;
    }
}