class Solution {
    public static int f(String s){
        char min = 'z';
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c < min){
                min = c;
                cnt = 1;
            } else if(c == min){
                cnt++;
            }
        }
        return cnt;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wf = new int[words.length];
        for(int i = 0; i < words.length; i++){
            wf[i] = f(words[i]);
        }

        Arrays.sort(wf);

        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int qf = f(queries[i]);
            int idx = upperBound(wf, qf);
            ans[i] = wf.length - idx;
        }

        return ans;
    }

    public static int upperBound(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] > target){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
