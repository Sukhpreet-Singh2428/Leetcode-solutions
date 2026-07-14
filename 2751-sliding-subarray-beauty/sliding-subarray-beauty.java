class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;
        
        int l = 0;
        int r = 0;
        
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        while(r < n){
            if(nums[r] < 0){
                mp.put(nums[r], mp.getOrDefault(nums[r], 0)+1);
            }
                
            if(r-l+1 > k){
                if(mp.containsKey(nums[l])){
                    mp.put(nums[l], mp.get(nums[l])-1);
                    if(mp.get(nums[l])==0){
                        mp.remove(nums[l]);
                    }
                }
                l++;
            }
            
            if(r-l+1 == k){
                if(mp.size()==0) ls.add(0);
                else{
                    int cnt = 0;
                    boolean found = false;
                    for(int key : mp.keySet()){
                        cnt += mp.get(key);
                        if(cnt>=x){
                            ls.add(key);
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        ls.add(0);
                    }
                }
            }
            
            r++;
        }
        
        int[] ans = new int[ls.size()];
        for(int i=0; i<ls.size(); i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}