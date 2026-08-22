class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for(int i=0; i<items1.length; i++){
            int value = items1[i][0];
            int weight = items1[i][1];
            mp.put(value, mp.getOrDefault(value, 0)+weight);
        }
        for(int i=0; i<items2.length; i++){
            int value = items2[i][0];
            int weight = items2[i][1];
            mp.put(value, mp.getOrDefault(value, 0)+weight);
        }

        List<List<Integer>> ret = new ArrayList<>();
        for(int key : mp.keySet()){
            List<Integer> ls = new ArrayList<>();
            ls.add(key);
            ls.add(mp.get(key));
            ret.add(ls);
        }

        return ret;
    }
}