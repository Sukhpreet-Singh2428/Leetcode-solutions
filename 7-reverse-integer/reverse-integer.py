class Solution:
    def reverse(self, x: int) -> int:
        str_n = str(x)
        if(x<0):
            reverse = "-" + str_n[:0:-1]
        else:
            reverse = str_n[::-1]
        reverse_int = int(reverse)
        if reverse_int < -2**31 or reverse_int > 2**31 - 1:
            return 0
        return reverse_int
        