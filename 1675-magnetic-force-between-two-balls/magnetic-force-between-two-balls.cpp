class Solution {
public:
    bool canWePlace(vector<int>& position, int dist, int m){
        int n = position.size();

        int cntBalls = 1;
        int last = position[0];
        for(int i=0; i<n; i++){
            if( (position[i] - last) >= dist ){
                cntBalls++;
                last = position[i];
            }
            if(cntBalls >= m) return true;
        }
        return false;
    }
    int maxDistance(vector<int>& position, int m) {
        int n = position.size();

        sort(position.begin(), position.end());
        int maxi = position[n-1];
        int mini = position[0];
        int low = 1;
        int high = maxi-mini;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(canWePlace(position, mid, m) == true){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return high;
    }
};