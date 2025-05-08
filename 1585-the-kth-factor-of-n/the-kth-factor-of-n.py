class Solution:
    def kthFactor(self, n: int, k: int) -> int:
        list = []
        for i in range(1,n+1):
            if(n%i==0):
                list.append(i)
            
        if k>len(list):
             return -1
        else:
            return list[k-1]
        