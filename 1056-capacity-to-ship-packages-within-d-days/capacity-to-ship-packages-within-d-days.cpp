class Solution {
public:
    int reqDays(vector<int>& weights, int capacity){
        int n = weights.size();
        int days = 1;
        int load = 0;
        for(int i=0; i<n; i++){
            if((load + weights[i]) > capacity){
                days++;
                load = weights[i];
            }
            else{
                load += weights[i];
            }
        }
        return days;
    }
    int shipWithinDays(vector<int>& weights, int days) {
        int n = weights.size(); 
        int sumOfWeights = 0;
        for(auto it : weights){
            sumOfWeights += it;
        }

        int low = *max_element(weights.begin(), weights.end());
        int high = sumOfWeights;
        int ans = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            int requiredDays = reqDays(weights, mid);
            if(requiredDays <= days){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
};