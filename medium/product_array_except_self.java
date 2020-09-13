class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 2) return new int[] {nums[1], nums[0]};
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        // product left side
        for(int i = 0; i< n; i++){
            if(i == 0) {
                left[i] = nums[i];
            } else {
                left[i] = nums[i] * left[i-1];
            }
        }
        // product right side
        for(int i = n - 1; i > 0; i--){
            if(i == n - 1) {
                right[i] = nums[i];
            } else {
                right[i] = nums[i] * right[i+1];
            }
        }
        // answer = left side * right side of index
        for(int i = 0; i < n; i++){
            if(i == 0) {
                ans[i] = right[i+1];
            } else if (i == n-1){
                ans[i] = left[i-1];
            } else {
                ans[i] = left[i-1] * right[i+1];
            }
        }
        return ans;
    }
}