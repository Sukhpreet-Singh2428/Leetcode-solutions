class Solution {
    public static void palindromePartition(int idx, String s, List<List<String>> ans, List<String> ls, int n){
        if(idx == n){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int j=idx; j<n; j++){
            if(check(s, idx, j)){
                String Substring = s.substring(idx, j+1);
                ls.add(Substring);
                palindromePartition(j+1, s, ans, ls, n);
                ls.remove(ls.size()-1); 
            }
        }
    }
    public static boolean check(String s, int left, int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        palindromePartition(0, s, ans, ls, s.length());
        return ans;
    }
}