class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for(int i=0; i<nums1.length; i++){
            int id = nums1[i][0];
            int val = nums1[i][1];
            mp.put(id, mp.getOrDefault(id, 0)+val);
        }
        for(int i=0; i<nums2.length; i++){
            int id = nums2[i][0];
            int val = nums2[i][1];
            mp.put(id, mp.getOrDefault(id, 0)+val);
        }

        int[][] ans = new int[mp.size()][2];
        int idx = 0;
        for(int key : mp.keySet()){
            ans[idx][0] = key;
            ans[idx][1] = mp.get(key);
            idx++;
        }

        return ans;
    }
}