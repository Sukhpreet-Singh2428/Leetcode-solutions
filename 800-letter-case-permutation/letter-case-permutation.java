class Solution {
    public void func(int idx, String s, String str, List<String> ls){
        if(idx==s.length()){
            ls.add(str);
            return;
        }

        char c = s.charAt(idx);
        if((c>='a' && c<='z') || (c>='A' && c<='Z')){
            func(idx+1, s, str+c, ls);
            if(c>='a' && c<='z') func(idx+1, s, str+(char)(c-32), ls);
            else func(idx+1, s, str+(char)(c+32), ls);
        }
        else{
            func(idx+1, s, str+c, ls);
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> ls = new ArrayList<>();

        func(0, s, "", ls);

        return ls;
    }
}