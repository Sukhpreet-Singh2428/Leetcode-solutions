class Solution {
    public String func(char c){
        int num = c;

        StringBuilder s = new StringBuilder();
        while(num != 0){
            s.append(num%2);
            num = num/2;
        }
        s.append(0);

        s.reverse();
        return s.toString();
    }
    public boolean palindrome(String s){
        int i = 0;
        int j = s.length()-1;

        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    public boolean isPalindromic(String s) {
        StringBuilder str = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            str.append(func(c));
        }
        System.out.println(str.toString());
        return palindrome(str.toString());
    }
}