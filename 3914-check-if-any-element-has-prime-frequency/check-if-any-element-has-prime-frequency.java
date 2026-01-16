class Solution {
    public static boolean isPrime(int n){
        int cnt = 0;
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i==0){
                cnt++;
                if(n/i != i){
                    cnt++;
                }
            }
        }
        if(cnt==2) return true;
        return false;
    }
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        for(int key : mp.keySet()){
            if(isPrime(mp.get(key))){
                return true;
            }
        }

        return false;
    }
}