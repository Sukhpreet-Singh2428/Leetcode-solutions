class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;

        int l = 0;
        int r = 0;
        int sum = 0;
        int ans = 0;
        int cnt = 0;

        while(r < n){
            sum += arr[r];
            cnt++;

            if(cnt==k){
                int avg = sum/k;
                if(avg >= threshold){
                    ans++;
                }
                sum -= arr[l];
                l++;
                cnt--;
            }

            r++;
        }

        return ans;
    }
}