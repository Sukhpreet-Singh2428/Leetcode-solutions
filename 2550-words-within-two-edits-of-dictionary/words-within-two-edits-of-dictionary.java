class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for(int i=0; i<queries.length; i++){
            String s = queries[i];

            for(int j=0; j<dictionary.length; j++){
                String str = dictionary[j];
                int cnt = 0;
                for(int k=0; k<str.length(); k++){
                    char c1 = s.charAt(k);
                    char c2 = str.charAt(k);

                    if(c1 != c2){
                        cnt++;
                    }
                    if(cnt>2) break;
                }
                
                if(cnt<=2){
                    ans.add(s);
                    break;
                }
            }
        }

        return ans;
    }
}