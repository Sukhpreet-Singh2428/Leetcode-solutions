class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # lst = [x for x in nums1 if x in nums2]
        # lst_set = set(lst)
        # result = list(lst_set)
        # return result
        return list( set(nums1) & set(nums2) )   # & --> Intersection