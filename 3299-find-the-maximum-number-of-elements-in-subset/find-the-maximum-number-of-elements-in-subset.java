class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        int ans = 1;
        int ones = 0;
        for(int key : mp.keySet()){
            if(key==1){
                ones = mp.get(key);
                continue;
            }

            long curr = key;
            int cnt = 0;
            while(mp.getOrDefault((int)curr, 0) >= 2 && mp.containsKey((int)(curr * curr))){
                if(curr > Long.MAX_VALUE/curr) break;
                curr = curr*curr;
                cnt += 2;
            }

            if(mp.containsKey((int)curr)){
                cnt += 1;
            } 

            ans = Math.max(ans, cnt);           
        }

        if(ones%2==0) ans = Math.max(ans, ones-1);
        else ans = Math.max(ans, ones);

        return ans;
    }
}