class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        # result = [x for x in t if x not in s]  --> Fails when the extra character already exists in 
        # result_str = ""                           s but just has higher frequency.
        # for i in result:
        #     result_str = result_str + str(i)
        # return result_str
        result = ""
        for ch in t:
            if s.count(ch) != t.count(ch):
                result = ch
                break
        return result