class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        maxVolume = 0
        l = 0
        r = len(height) - 1
        while(l < r):
            #current volume
            vol = min(height[l], height[r]) * (r - l)
            #if current volume is greater, replace highest volume found 
            if(vol > maxVolume):
                maxVolume = vol
            #shift l or r
            if(height[l] < height[r]):
                l += 1
            else:
                r -= 1

        return maxVolume