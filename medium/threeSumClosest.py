class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        n = len(nums)
        nums.sort()
        closest = sum(nums[:3]) #initialize closest to first 3 integers
        #nums only has 3 integers
        if n == 3:
            return closest
        
        for i in range(n):
            j = i + 1
            k = n - 1
            while(j < k):
                threeSum = nums[i] + nums[j] + nums[k]
                
                if abs(threeSum - target) < abs(closest - target): #check if closer
                    closest = threeSum
                #shift j or k
                if threeSum > target:
                    k -= 1
                elif threeSum < target:
                    j += 1
                else:
                    return target
                
        return closest
        