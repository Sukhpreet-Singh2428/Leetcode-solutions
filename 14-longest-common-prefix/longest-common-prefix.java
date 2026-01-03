class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length;

        String first = strs[0];
        String last = strs[n-1];
        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder("");
        while(i<first.length() && j<last.length()){
            if(first.charAt(i) != last.charAt(j)){
                break;
            }
            ans.append(first.charAt(i));
            i++;
            j++;
        }

        return ans.toString();
    }
}