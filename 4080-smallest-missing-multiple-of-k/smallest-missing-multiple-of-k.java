class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> st = new HashSet<>();

        int maxi = -1;
        for(int x : nums){
            maxi = Math.max(maxi, x);
            st.add(x);
        }

        int i = 2;
        int num = k;
        while(num <= maxi){
            if(!st.contains(num)) return num;
            num = k*i;
            i++;
        }

        return num;
    }
}