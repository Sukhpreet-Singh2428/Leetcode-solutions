class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);

            StringBuilder s = new StringBuilder();
            for(char ch : arr){
                s.append(ch);
            }
            
            if(!mp.containsKey(s.toString())){
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                mp.put(s.toString(), ls);
            }
            else{
                mp.get(s.toString()).add(strs[i]);
            }
        }

        for(String s : mp.keySet()){
            ans.add(new ArrayList<>(mp.get(s)));
        }

        return ans;
    }
}