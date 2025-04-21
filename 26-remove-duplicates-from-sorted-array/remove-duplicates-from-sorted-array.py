class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        seen = []
        expectednums = []
        for num in nums:
            if num not in seen:
                seen.append(num)
                expectednums.append(num)
        nums[:len(expectednums)] = expectednums   #modified the actual input list
        return len(expectednums)