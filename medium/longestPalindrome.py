class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        pal = ''  # longest palindrome
        for i in range(len(s)):  # 0 to n
            for j in range(len(s), i, -1):  # n to 0
                if(len(pal) >= j-i):  # break if palindrome found is longer than possibilities in current iteration
                    break
                elif(s[i:j] == s[i:j][::-1]): # check if palindrome
                    pal = s[i:j]
                    break
        return pal