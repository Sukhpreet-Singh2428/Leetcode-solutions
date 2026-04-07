class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }

        HashSet<Integer> st = new HashSet<>();
        for(char key : mp.keySet()){
            st.add(mp.get(key));
            if(st.size() > 1) return false;
        }

        return true;
    }
}