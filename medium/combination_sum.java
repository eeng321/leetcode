class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        build(candidates, target, new ArrayList<Integer>(), 0, 0);
        return ans;
    }
    
    private void build(int[] candidates, int target, List<Integer> currList, int currSum, int i){
        if(currSum == target) ans.add(new ArrayList<Integer>(currList));
        if(currSum >= target || i >= candidates.length) return;
        
        if(candidates[i]+currSum <= target){
            currList.add(candidates[i]);
            build(candidates, target, currList, candidates[i]+currSum, i);
            currList.remove(currList.size() - 1);
        }
        build(candidates,target,currList,currSum,i+1);
    }
}
