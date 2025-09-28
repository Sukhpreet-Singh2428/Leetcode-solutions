class Solution {
public:
    long long possible(vector<int>& bloomDay, int day, int m, int k){
        int n = bloomDay.size(); 

        int cnt = 0;
        long noOfBouquets = 0;
        for(int i=0; i<n; i++){
            if(bloomDay[i] <= day){
                cnt++;
            }
            else{
                noOfBouquets += cnt/k;
                cnt = 0;
            }
        }
        noOfBouquets += cnt/k;
        return noOfBouquets;
    }
    int minDays(vector<int>& bloomDay, int m, int k) {
        int n = bloomDay.size();
        if ((long long)n < (long long)m * (long long)k) return -1;

        int low = *min_element(bloomDay.begin(), bloomDay.end());
        int high = *max_element(bloomDay.begin(), bloomDay.end());
        int ans = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            long long noOfBouquets = possible(bloomDay, mid, m, k);
            if(noOfBouquets >= m){
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