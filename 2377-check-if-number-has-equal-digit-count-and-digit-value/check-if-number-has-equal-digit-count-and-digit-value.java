class Solution {
    public boolean digitCount(String num) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<num.length(); i++){
            int x = num.charAt(i) - '0';
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }

        for(int i=0; i<num.length(); i++){
            if(mp.getOrDefault(i, 0) != num.charAt(i)-'0'){
                return false;
            }
        }

        return true;
    }
}