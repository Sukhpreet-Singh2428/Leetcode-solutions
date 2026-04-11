class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            String s = arr[i];
            mp.put(s, mp.getOrDefault(s, 0)+1);
        }

        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(mp.get(arr[i]) == 1){
                cnt++;
                if(cnt==k){
                    return arr[i];
                }
            }
        }

        return "";
    }
}