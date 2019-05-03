class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        def backtrack(combination, left, right):
            if left <= 0 and right <= 0:
                # the combination is done
                output.append(combination)
                return
            if left > 0:
                backtrack(combination + "(", left-1, right)
            if left < right:
                backtrack(combination + ")", left, right-1)
                    
        output = [] 
        backtrack("", n, n)
        
        return output