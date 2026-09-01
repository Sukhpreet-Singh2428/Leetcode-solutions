class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();

        for(int i=0; i<n; i++){
            if(!seen.contains(nums[i])){
                if(mp.containsKey(nums[i])){
                    if(Math.abs(i - mp.get(nums[i])) != 1){
                        mp.remove(nums[i]);
                        seen.add(nums[i]);
                    }
                    else{
                        mp.put(nums[i], i);
                    }
                }
                else{
                    mp.put(nums[i], i);
                }
            }
        }

        for(int key : mp.keySet()){
            ans++;
        }

        return ans;
    }
}