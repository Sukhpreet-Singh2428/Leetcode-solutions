class Solution {
    public int numDifferentIntegers(String word) {
        HashSet<String> st = new HashSet<>();

        StringBuilder s = new StringBuilder("");
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(c>='0' && c<='9'){
                s.append(c);
            }
            else if(s.length() > 0){
                int j = 0;
                while(j<s.length()){
                    if(s.charAt(j)=='0') j++;
                    else break;
                }

               if(j==s.length()){
                st.add("0");
               }
               else{
                st.add(s.substring(j));
               }
               s.setLength(0);
            }
        }
        if(s.length()>0){
            int j = 0;
            while(j<s.length()){
                if(s.charAt(j)=='0') j++;
                else break;
            }

            if(j==s.length()){
                st.add("0");
            }
            else{
                st.add(s.substring(j));
            }
        }

        return st.size();
    }
}