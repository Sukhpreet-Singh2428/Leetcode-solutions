class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        # result = []    --> TLC in 92/93 !! sad !!
        # seen = []
        # for i in nums:
        #     if(nums.count(i)>len(nums)//3):
        #         if(i not in seen):
        #             result.append(i)
        #             seen.append(i)
        # return result

        count = {}
        for i in nums:
            if i in count:
                count[i] += 1
            else:
                count[i] = 1
        result = []
        for key in count:
            if(count[key]>len(nums)//3):
                result.append(key)
        return result