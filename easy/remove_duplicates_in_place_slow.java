class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for(int i=1; i<len; i++){
            if(nums[i-1] == nums[i]){
                deleteIndex(nums, i);
                len--;
                i--;
            }
        }
        return len;
    }
    
    public void deleteIndex(int[] nums, int i) {
        for(int j = i; j < nums.length - 1; j++){
            nums[j] = nums[j+1];
        }
    }
}