class Solution {
    public boolean isGood(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int maxi = Integer.MIN_VALUE;

        for(int x : nums){
            maxi = Math.max(maxi, x);
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }

        if(mp.get(maxi) != 2) return false;

        for(int i=1; i<=maxi-1; i++){
            if(!mp.containsKey(i)) return false;
            if(mp.get(i) != 1) return false;
        }

        return true;
    }
}