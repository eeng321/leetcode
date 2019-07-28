class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums:
            return -1
        l = len(nums)
        if nums[0] <= target:
            for i in range(l):
                if nums[i] == target:
                    return i
                elif nums[i] > target:
                    break
        else:    
            for i in range(l-1, -1, -1):
                if nums[i] == target:
                    return i
                elif nums[i] < target:
                    break
        return -1
                    