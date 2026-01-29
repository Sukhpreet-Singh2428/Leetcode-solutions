class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int x : arr){
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }

        int maxi = -1;
        for(int key : mp.keySet()){
            if(mp.get(key) == key){
                maxi = Math.max(maxi, key);
            }
        }

        return maxi;
    }
}