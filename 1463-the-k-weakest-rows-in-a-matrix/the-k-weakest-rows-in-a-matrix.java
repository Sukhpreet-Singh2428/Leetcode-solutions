class Solution {
    public static int last(int[] arr, int target){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                ans = mid;
                low = mid+1;
            }
            else if(arr[mid] < target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        TreeMap<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        for(int i=0; i<mat.length; i++){
            int l = last(mat[i], 1);
            mp.putIfAbsent(l+1, new ArrayList<>());
            mp.get(l+1).add(i);
        }

        int[] ans = new int[k];
        int cnt = 0;
        for(int key : mp.keySet()){
            for(int idx : mp.get(key)){
                if(cnt==k) return ans;
                ans[cnt++] = idx;
            }
        }
        return ans;
    }
}