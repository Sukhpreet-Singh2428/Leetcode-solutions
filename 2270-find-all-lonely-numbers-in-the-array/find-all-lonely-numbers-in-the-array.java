class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int x : nums){
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }

        List<Integer> ans = new ArrayList<>();
        for(int x : mp.keySet()){
            if(mp.get(x)==1 && !mp.containsKey(x-1) && !mp.containsKey(x+1)){
                ans.add(x);
            }
        }

        return ans;
    }
}