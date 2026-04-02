class Solution {
    public int minimumCardPickup(int[] cards) {
        int ans = Integer.MAX_VALUE;

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<cards.length; i++){
            if(mp.containsKey(cards[i])){
                ans = Math.min(ans, i-mp.get(cards[i])+1);
            }
            mp.put(cards[i], i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}