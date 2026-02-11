class Solution {
    public static int countSetBits(int n){
        int cnt = 0;
        while(n != 0){
            cnt += (n&1);
            n = n>>1;
        }
        return cnt;
    }
    public int[] sortByBits(int[] arr) {
        TreeMap<Integer, ArrayList<Integer>> mp = new TreeMap<>();

        for(int i=0; i<arr.length; i++){
            int cnt = countSetBits(arr[i]);
            if(mp.containsKey(cnt)){
                mp.get(cnt).add(arr[i]);
            }
            else{
                mp.put(cnt, new ArrayList<>());
                mp.get(cnt).add(arr[i]);
            }
        }

        int[] ans = new int[arr.length];
        int idx = 0;
        for(int key : mp.keySet()){
            Collections.sort(mp.get(key));
            for(int i=0; i<mp.get(key).size(); i++){
                ans[idx] = mp.get(key).get(i);
                idx++;
            }
        }

        return ans;
    }
}