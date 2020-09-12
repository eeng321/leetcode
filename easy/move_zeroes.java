class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        int i = 0;
        int count = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            } else {
                count++;
            }
        }
        int end = nums.length-1;
        while(count > 0){
            nums[end] = 0;
            count--;
            end--;
        }
    }
}