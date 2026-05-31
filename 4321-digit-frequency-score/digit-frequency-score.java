class Solution {
    public int digitFrequencyScore(int n) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        while(n != 0){
            int x = n%10;
            mp.put(x, mp.getOrDefault(x, 0)+1);
            n = n/10;
        }

        int ans = 0;
        for(int key : mp.keySet()){
            ans += key * mp.get(key);
        }

        return ans;
    }
}