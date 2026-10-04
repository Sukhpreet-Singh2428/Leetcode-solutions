class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            mp.put(arr1[i], mp.getOrDefault(arr1[i], 0)+1);
        }

        int idx = 0;
        for(int i=0; i<arr2.length; i++){
            for(int j=0; j<mp.get(arr2[i]); j++){
                arr1[idx] = arr2[i];
                idx++;
            }
            mp.remove(arr2[i]);
        }

        List<Integer> ls = new ArrayList<>();
        for(int key : mp.keySet()){
            for(int i=0; i<mp.get(key); i++){
                ls.add(key);
            }
        }
        Collections.sort(ls);
        for(int x : ls){
            arr1[idx] = x;
            idx++;
        }

        return arr1;
    }
}