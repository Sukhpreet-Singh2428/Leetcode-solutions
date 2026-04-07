class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<String, Integer> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            String str = "";
            for(int j=i; j<s.length(); j++){
                if(str.length() == 3) break;
                str += s.charAt(j);
            }
            if(str.length() == 3) mp.put(str, mp.getOrDefault(str, 0)+1);
        }

        int cnt = 0;
        for(String key : mp.keySet()){
            HashSet<Character> st = new HashSet<>();
            for(int i=0; i<key.length(); i++){
                st.add(key.charAt(i));
            }
            if(key.length() == st.size()) cnt += mp.get(key);
        }

        return cnt;
    }
}