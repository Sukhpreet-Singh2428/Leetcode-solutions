class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> st = new HashSet<>();
        for(int x : candyType){
            st.add(x);
        }

        int eat = candyType.length/2;

        return st.size()>eat ? eat : st.size();
    }
}