class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums:
            l, r = 0, len(nums)-1
            while l <= r:
                if nums[l] == target and nums[r] == target:
                    return [l,r]
                if nums[l] < target:
                    l += 1
                if nums[r] > target:
                    r -= 1
                
        return [-1,-1]