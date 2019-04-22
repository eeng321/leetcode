class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if(len(nums) < 2): 
            return nums
        dict = {nums[0] : 0}
        for i in range(1,len(nums)):
            checkNum = target - nums[i]
            if(checkNum in dict.keys()):
                return [i, dict[checkNum]]
            else:
                dict[nums[i]] = i
        