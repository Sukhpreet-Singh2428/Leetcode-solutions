class Solution {
    public static void func(int idx, String s, int n, List<String> ls, String[] arr){
        if(idx >= n){
            ls.add(s);
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(s.length()==0 || s.charAt(s.length()-1)!=arr[i].charAt(0)){
                func(idx+1, s+arr[i].charAt(0), n, ls, arr);
            }
        }
    }
    public String getHappyString(int n, int k) {
        String[] arr = {"a", "b", "c"};

        List<String> ls = new ArrayList<>();
        func(0, "", n, ls, arr);

        if(k > ls.size()) return "";
        return ls.get(k-1);
    }
}