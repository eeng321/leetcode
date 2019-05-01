class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if(numRows <= 1):
            return s
        
        inc = 1
        count = 0
        #initialize empty strings
        arr = [""] * numRows
        
        #concatenate each character into the corresponding string
        for i in range(len(s)):
            if(count < 0):
                count = 1
                inc *= -1
            elif(count >= numRows):
                count = numRows - 2
                inc *= -1
    
            arr[count] += s[i]
            count += inc
        
        #concatenate all strings to form the answer  
        ans = ""        
        for i in range(len(arr)):
            ans += arr[i]
        
        return ans