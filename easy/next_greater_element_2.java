class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if(n == 0) return res;
        Stack<Integer> s = new Stack<>();
        
        for(int i = n-1; i >= 0; i--){
            s.push(i);
        }
        for(int i = n-1; i >= 0; i--){
            res[i] = -1;
            while(!s.isEmpty() && nums[s.peek()] <= nums[i]){
                s.pop();
            }
            if(!s.isEmpty()){
                res[i] = nums[s.peek()];
            }
            s.push(i);
        }
        return res;
    }
}