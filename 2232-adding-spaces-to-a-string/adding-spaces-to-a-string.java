class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();

        int j = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(j<spaces.length && i == spaces[j]){
                ans.append(" ");
                j++;
                ans.append(c);
            }
            else{
                ans.append(c);
            }
        }

        return ans.toString();
    }
}