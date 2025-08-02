class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        int left = 0, right = 0;
        vector<int> ans;
        while(left<n1 && right<n2){
            if(nums1[left]<=nums2[right]){
                ans.push_back(nums1[left]);
                left++;
            }
            else{
                ans.push_back(nums2[right]);
                right++;
            }
        }
        while(left<n1){
            ans.push_back(nums1[left]);
            left++;
        }
        while(right<n2){
            ans.push_back(nums2[right]);
            right++;
        }

        if(ans.size()%2 != 0) return ans[ ans.size()/2 ];
        else{
            double m1 = ans[ ans.size()/2 -1 ];
            double m2 = ans[ ans.size()/2 ];
            return (m1+m2)/2;
        }
    }
};