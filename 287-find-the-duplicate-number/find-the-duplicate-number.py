class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        nums.sort()
        for i in range(len(nums)-1):
            if(nums[i]==nums[i+1]):
                return nums[i]
        # seen = set()
        # for x in nums:
        #     if x in seen:
        #         return x
        #     seen.add(x)