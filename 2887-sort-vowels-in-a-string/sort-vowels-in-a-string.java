class Solution {
    public static boolean isVowel(char c){
        c = Character.toLowerCase(c);
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        return false;
    }
    public String sortVowels(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                arr.add(c);
            }
        }
        if(arr.size()==0) return s;
        Collections.sort(arr);
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for(int i=0; i<s.length(); i++){
            if(isVowel(s.charAt(i))){
                ans.append(arr.get(j));
                j++;
            }
            else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}