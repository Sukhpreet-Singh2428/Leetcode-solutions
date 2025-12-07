class Solution {
    public String reverseVowels(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            char c = Character.toLowerCase(ch);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                arr.add(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        int j = arr.size() - 1;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            char c = Character.toLowerCase(ch);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                ans.append(arr.get(j));
                j--;
            }
            else{
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}