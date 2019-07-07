class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        neg = ( (dividend < 0) != (divisor < 0) )
        
        ans = 0
        left = abs(dividend)
        div = abs(divisor)
        if div == 1:
            ans = left
        else:
            while left >= div:
                ans += 1
                left -= div
        
        if neg:
            return max(-ans, -2**31)
        else:
            return min(ans, 2**31 - 1)