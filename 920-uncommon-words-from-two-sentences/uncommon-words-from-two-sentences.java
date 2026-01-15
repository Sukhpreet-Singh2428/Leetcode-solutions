class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        
        HashMap<String, Integer> mp = new HashMap<>();
        for(String s : arr1){
            mp.put(s, mp.getOrDefault(s, 0)+1);
        }
        for(String s : arr2){
            mp.put(s, mp.getOrDefault(s, 0)+1);
        }

        ArrayList<String> ans = new ArrayList<>();
        for(String key : mp.keySet()){
            if(mp.get(key)==1){
                ans.add(key);
            }
        }

        return ans.toArray(new String[0]);
    }
}