class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        lst = []
        nums.sort()
        for i in range(len(nums)-1):
            if(nums[i]==nums[i+1]):
                lst.append(nums[i])
        return lst