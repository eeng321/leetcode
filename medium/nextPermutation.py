class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        #only 2 elements in nums, return reversed nums
        if n < 3: 
            return nums.reverse()
        
        def swap(list, pos1, pos2):
            temp = nums[pos1]
            nums[pos1] = nums[pos2]
            nums[pos2] = temp
        
        curr = n-2 #second last element
        prev = n-1 #last element
        first_smaller = 0 #first smaller element on the left
        #iterate through list starting from end to beginning
        while curr >= 0 and prev > 0:
            if nums[curr] < nums[prev]:
                first_smaller = curr #save the first smaller position
                nums[curr+1:] = sorted(nums[curr+1:]) #sort all elements on right side of current element
                break;
            curr -= 1
            prev -= 1
            
        i = first_smaller #start iterating from first smaller element position
        while i < n:
            if nums[i] > nums[first_smaller]: #found the next bigger element
                swap(nums,i,first_smaller) #swap the next bigger element with the first smaller element
                return nums
            i += 1
        #if it gets here then nums was already the largest permutation
        return nums.sort()