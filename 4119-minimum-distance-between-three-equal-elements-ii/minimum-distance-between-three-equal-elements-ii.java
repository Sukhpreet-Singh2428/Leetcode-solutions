class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(nums[i])){
                mp.get(nums[i]).add(i);
            }
            else{
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                mp.put(nums[i], ls);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (List<Integer> list : mp.values()) {
            int n = list.size();

            if (n >= 3) {
                for (int i = 0; i <= n - 3; i++) {
                    int a = list.get(i);
                    int c = list.get(i + 2);

                    ans = Math.min(ans, 2 * (c - a));
                }
            }
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}