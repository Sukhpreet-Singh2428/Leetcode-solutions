class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> st = new HashSet<>();
        for(int i=0; i<brokenLetters.length(); i++){
            st.add(brokenLetters.charAt(i));
        }

        String[] arr = text.split(" ");
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            String s = arr[i];
            boolean not = false;
            for(int j=0; j<s.length(); j++){
                if(st.contains(s.charAt(j))){
                    not = true;
                    break;
                }
            }
            if(!not) cnt++;
        }

        return cnt;
    }
}