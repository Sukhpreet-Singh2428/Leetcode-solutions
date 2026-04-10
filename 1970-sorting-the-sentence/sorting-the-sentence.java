class Solution {
    public String sortSentence(String s) {
        TreeMap<Character, String> mp = new TreeMap<>();
        int start = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c==' '){
                start = i+1;
            }
            else if(c>='0' && c<='9'){
                mp.put(c, s.substring(start, i));
            }
        }

        StringBuilder ans = new StringBuilder("");
        for(char key : mp.keySet()){
            ans.append(mp.get(key));
            if(mp.size() != key-'0') ans.append(" ");
        }

        return ans.toString();
    }
}