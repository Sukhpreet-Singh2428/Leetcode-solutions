class Solution {
    public static void reverseWord(StringBuilder ans, int i, int j){
        while(i<j){
            char temp = ans.charAt(i);
            ans.setCharAt(i, ans.charAt(j));
            ans.setCharAt(j, temp);
            i++;
            j--;
        }
    }
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder(s);
        ans.reverse();

        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;
        int n = s.length();
        while(j<n){
            while(j<n && ans.charAt(j) == ' ') j++;
            start = i;
            while(j<n && ans.charAt(j) != ' '){
                ans.setCharAt(i, ans.charAt(j));
                i++;
                j++;
            }
            end = i-1;

            reverseWord(ans, start, end);

            while (j < n && ans.charAt(j) == ' ') j++;
            if(j < n) {  
                ans.setCharAt(i, ' ');
                i++;
            }
        }

        return ans.substring(0, i);
    }
}