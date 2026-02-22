class Solution {
    public int scoreDifference(int[] nums) {
        int one = 0;
        boolean active = false;
        int two = 0;
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            cnt++;
            if(cnt==6){
                if(nums[i]%2==1){
                    if(active==false){
                        active = true;  
                    }
                    else{
                        active = false;
                    }
                }
                if(active==false){
                    two += nums[i];
                    active = true;  
                }
                else{
                    one += nums[i];
                    active = false;
                }
                cnt = 0;
            }
            else{
                if(nums[i]%2==1){
                    if(active==false){
                        two += nums[i];
                        active = true;  
                    }
                    else{
                        one += nums[i];
                        active = false;
                    }
                }
                else if(nums[i]%2==0 && active==true){
                    two += nums[i];
                }
                else if(nums[i]%2==0 && active==false){
                    one += nums[i];
                }
            }
        }

        return one-two;
    }
}