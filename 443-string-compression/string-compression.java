class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        StringBuilder ans = new StringBuilder();
        int i=0;
        while(i<n){
            char ch = chars[i];
            int cnt = 1;
            while((i+1)<n && ch==chars[i+1]){
                cnt++;
                i++;
            }
            ans.append(ch);
            if(cnt>1) ans.append(Integer.toString(cnt));

            i++;
        }
        String s = ans.toString();
        char[] arr = s.toCharArray();
        for(int j=0; j<arr.length; j++){
            chars[j] = arr[j];
        }
        return s.length();
    }
}