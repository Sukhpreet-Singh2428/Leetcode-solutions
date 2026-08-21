class Solution {
    public int sum(int num){
        int sum = 0;
        while(num != 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=lowLimit; i<=highLimit; i++){
            int x = sum(i);
            mp.put(x, mp.getOrDefault(x, 0)+1);
        }

        int ans = -1;
        for(int key : mp.keySet()){
            ans = Math.max(ans, mp.get(key));
        }

        return ans;
    }
}