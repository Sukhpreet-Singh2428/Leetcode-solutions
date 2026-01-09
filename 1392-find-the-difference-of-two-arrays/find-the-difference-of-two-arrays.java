class Solution {
    public static List<Integer> difference(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // i solved this problem by assumption of array is sorted, but after reading problem again
        // it is not sorted, that's why i sort the arrays. Bcz HashSet version solution is damm easy 
        // compare to this algo and especially after writing this code, i am not at all in mood of writing
        // simple approach of HashSet (LOL). 
        // Bcz of sort, the time complexity is increase by factor of logn compared to hashset version
        // TC : O(nlogn + mlogm) whereas HashSet has O(n+m)
        // SC : O(1) whereas HashSet has O(n+m)
        // This algo is god-level space optimized, works efficiently when memory constraints matter
        int n = nums1.length;
        int m = nums2.length;
        int i=0;
        int j=0;
        List<Integer> ans = new ArrayList<>();
        while(i<n && j<m){
            if(nums1[i] == nums2[j]){
                int temp = nums1[i];
                while(i<n && nums1[i]==temp){
                    i++;
                }
                while(j<m && nums2[j]==temp){
                    j++;
                }
            }
            else if(nums1[i]<nums2[j]){
                if(ans.size()==0 || nums1[i] != ans.get(ans.size()-1)) ans.add(nums1[i]);
                i++;
            }
            else{
                j++;
            }
        }
        while(i<n){
            if(ans.size()==0 || nums1[i] != ans.get(ans.size()-1)) ans.add(nums1[i]);
            i++;
        }

        return ans;
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> arr = new ArrayList<>();
        
        List<Integer> ans1 = difference(nums1, nums2);
        List<Integer> ans2 = difference(nums2, nums1);
        
        arr.add(ans1);
        arr.add(ans2);

        return arr;
    }
}