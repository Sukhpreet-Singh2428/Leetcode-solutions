class Solution {
    public void func(int num, int last, int cnt, int n, int k, List<Integer> ls){
        if(cnt==n){
            ls.add(num);
            return;
        }

        if(last+k <= 9){
            func(num*10+(last+k), last+k, cnt+1, n, k, ls);
        }
        if(last-k <= 9 && last-k>=0 && k!=0){
            func(num*10+(last-k), last-k, cnt+1, n, k, ls);
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ls = new ArrayList<>();

        for(int i=1; i<=9; i++){
            func(i, i, 1, n, k, ls);
        }

        int[] ans = new int[ls.size()];
        for(int i=0; i<ls.size(); i++){
            ans[i] = ls.get(i);
        }

        return ans;
    }
}