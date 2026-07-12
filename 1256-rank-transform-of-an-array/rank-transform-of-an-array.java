class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        HashMap<Integer, Integer> mp = new HashMap<>();
        int rank = 1;
        for(int x : temp){
            if(!mp.containsKey(x)){
                mp.put(x, rank);
                rank++;
            }
        }

        for(int i=0; i<arr.length; i++){
            temp[i] = mp.get(arr[i]);
        }

        return temp;
    }
}