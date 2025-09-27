class Solution {
public:
    int findMAX(vector<int>& piles){
        int n = piles.size();
        int maxi = INT_MIN;
        for(int i=0; i<n; i++){
            if(piles[i] > maxi){
                maxi = piles[i];
            }
        }
        return maxi;
    }
    long long calculateTotalTime(vector<int>& piles, int perHour){
        int n = piles.size();
        long long total = 0;
        for(int i=0; i<n; i++){
            total += ceil( (double)piles[i]/(double)perHour);
        }
        return total;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int n = piles.size();

        int low = 1;
        // int high = *max_element(piles.begin(), piles.end());
        int high = findMAX(piles);
        int ans = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            long long totalHrs = calculateTotalTime(piles, mid);
            if(totalHrs <= h){
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