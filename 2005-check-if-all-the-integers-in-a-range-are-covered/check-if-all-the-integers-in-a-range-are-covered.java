class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        HashSet<Integer> st = new HashSet<>();
        for(int i=0; i<ranges.length; i++){
            for(int j = ranges[i][0]; j <= ranges[i][1]; j++){
                st.add(j);
            }
        }

        for(int i=left; i<=right; i++){
            if(!st.contains(i)){
                return false;
            }
        }

        return true;
    }
}