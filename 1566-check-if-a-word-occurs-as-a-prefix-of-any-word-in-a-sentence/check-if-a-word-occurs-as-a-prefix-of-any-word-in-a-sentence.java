class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for(int i=0; i<arr.length; i++){
            String s = arr[i];
            Boolean check = true;
            if(s.length() < searchWord.length()) continue;
            for(int j=0; j<searchWord.length(); j++){
                if(s.charAt(j) != searchWord.charAt(j)){
                    check = false;
                    break;
                }
            }
            if(check){
                return i+1;
            }
        }

        return -1;
    }
}