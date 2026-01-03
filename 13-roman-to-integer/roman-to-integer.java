class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        
        int sum = 0;
        int prev = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int val = mp.get(c);
            if(prev < val){
                sum -= prev;
                sum += val-prev;
            }
            else{
                sum += val;
            }
            prev = val;
        }
        
        return sum;
    }
}