class Solution {
    public void digits(int num, List<Integer> ls){
        while(num != 0){
            int d = num%10;
            ls.add(d);
            num = num/10;
        }
    }
    public int maxProduct(int n) {
        List<Integer> ls = new ArrayList<>();

        digits(n, ls);

        Collections.sort(ls);

        int ans = ls.get(ls.size()-2) * ls.get(ls.size()-1);

        return ans;
    }
}