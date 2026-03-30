class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int x : arr){
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }
        for(int x : target){
            mp.put(x, mp.getOrDefault(x, 0)-1);
        }

        for(int key : mp.keySet()){
            if(mp.get(key) != 0){
                return false;
            }
        }

        return true;
    }
}