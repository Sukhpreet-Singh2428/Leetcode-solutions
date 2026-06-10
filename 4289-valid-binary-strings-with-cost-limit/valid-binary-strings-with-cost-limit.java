class Solution {
    public static void func(int idx, int sum, String s, int n, int k, List<String> ls){
        if(s.length() == n){
            if(sum<=k){
                ls.add(s);
            }
            return;
        }
        if(sum>k){
            return;
        }

        func(idx+1, sum, s+"0", n, k, ls);
        if(s.length()==0 || s.charAt(s.length()-1) != '1') func(idx+1, sum+idx, s+"1", n, k, ls);
    }
    public List<String> generateValidStrings(int n, int k) {
        List<String> ls = new ArrayList<>();

        func(0, 0, "", n, k, ls);

        return ls;
    }
}