class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxLen = 0;

        while(r < n){
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0)+1);

            if(mp.size() > 2){
                while(mp.size() > 2){
                    mp.put(fruits[l], mp.get(fruits[l])-1);
                    if(mp.get(fruits[l]) == 0){
                        mp.remove(fruits[l]);
                    }
                    l++;
                }
            }

            if(mp.size() <= 2){
                maxLen = Math.max(maxLen, r-l+1);
            }

            r++;
        }

        return maxLen;
    }
}