class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> ls = new ArrayList<>();

        HashMap<String, Integer> mp = new HashMap<>();
        int l = 0;
        int r = 0;
        int len = 0;

        while(r < n){
            len++;

            if(len > 10){
                while(len > 10){
                    l++;
                    len--;
                }
            }

            if(len==10){
                String str = s.substring(l, r+1);
                mp.put(str, mp.getOrDefault(str, 0)+1);
            }

            r++;
        }

        for(String key : mp.keySet()){
            if(mp.get(key) > 1){
                ls.add(key);
            }
        }

        return ls;
    }
}