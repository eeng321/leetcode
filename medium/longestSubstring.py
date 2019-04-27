class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if(len(s) <= 1):
            return len(s)
        sub = {}
        longest = 0
        
        n = len(s)
        for i in range(0, n):
            letter = s[i]
            sub[letter] = 1
            
        maxCount = len(sub)
        sub.clear()
        i = 0
        j = 0
        while i < n and j < n:
            letter = s[j]
            if(letter in sub.keys()):
                if(len(sub) > longest):
                    longest = len(sub)
                if(len(sub) == maxCount):
                    return maxCount
                i = sub.get(letter) + 1
                j = i
                sub.clear()
                continue
            else:
                sub[letter] = j
                j += 1
                if(len(sub) > longest):
                    longest = len(sub)
        return longest