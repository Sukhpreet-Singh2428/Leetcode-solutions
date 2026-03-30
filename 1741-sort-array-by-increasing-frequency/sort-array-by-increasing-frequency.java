class Pair{
    int key;
    int value;
    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int x : nums){
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }

        ArrayList<Pair> ls = new ArrayList<>();
        for(int key : mp.keySet()){
            ls.add(new Pair(key, mp.get(key)));
        }

        Collections.sort(ls, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.value == b.value){
                    return b.key - a.key;
                }
                return a.value - b.value;
            }
        });

        int[] ans = new int[nums.length];
        int idx = 0;
        for(int i=0; i<ls.size(); i++){
            int freq = ls.get(i).value;
            for(int j=0; j<freq; j++){
                ans[idx] = ls.get(i).key;
                idx++;
            }
        }

        return ans;
    }
}