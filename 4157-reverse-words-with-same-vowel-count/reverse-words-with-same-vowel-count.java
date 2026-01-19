class Solution {
    public static boolean isVowel(char c){
        c = Character.toLowerCase(c);
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        return false;
    }
    public String reverseWords(String s) {
        String[] arr = s.split(" ");

        String first = arr[0];
        int vowelCnt = 0;
        for(int i=0; i<first.length(); i++){
            if(isVowel(first.charAt(i))){
                vowelCnt++;
            }
        }

        for(int i=1; i<arr.length; i++){
            StringBuilder word = new StringBuilder(arr[i]);
            int cnt = 0;
            for(int j=0; j<word.length(); j++){
                if(isVowel(word.charAt(j))){
                    cnt++;
                }
            }
            if(cnt==vowelCnt){
                arr[i] = word.reverse().toString();
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            ans.append(arr[i]);
            if(i != arr.length-1){
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}