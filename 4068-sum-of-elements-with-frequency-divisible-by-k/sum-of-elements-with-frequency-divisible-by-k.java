class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue() % k == 0){
                sum += entry.getKey() * entry.getValue();
            }
        }

        if(sum % k == 0) return sum;
        return 0;
    }
}