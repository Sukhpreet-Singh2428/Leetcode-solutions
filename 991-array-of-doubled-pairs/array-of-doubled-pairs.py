class Solution:
    def canReorderDoubled(self, arr: List[int]) -> bool:
        count = Counter(arr)  # <-- dict for calc. freq or manually bhi kar sakte hai !!
        for x in sorted(arr,key=abs):   # After sorting by abs: [-2, 2, -4, 4]
            if count[x] == 0:
                continue
            if count[2*x] == 0:
                return False
            count[x] -= 1
            count[2*x] -= 1
        return True