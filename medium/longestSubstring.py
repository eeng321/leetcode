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
        for i in range(0, len(s)):
            letter = s[i]
            sub[letter] = 1
        maxCount = len(sub)
        sub.clear()
        for i in range(0,len(s)):
            for j in range(i,len(s)):
                letter = s[j]
                if(letter in sub.keys()):
                    if(len(sub) == maxCount):
                        return maxCount
                    if(len(sub) > longest):
                        longest = len(sub)
                    sub.clear()
                    break
                else:
                    sub[letter] = 1
                    if(len(sub) > longest):
                        longest = len(sub)
        return longest
            
            
            
            