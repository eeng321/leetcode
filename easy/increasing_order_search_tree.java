/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(nums, root);
        TreeNode ans = new TreeNode();
        TreeNode cur = ans;
        for(int num : nums) {
            cur.right = new TreeNode(num);
            cur = cur.right;
        }
        return ans.right;
    }
    
    private void inOrder(List nums, TreeNode cur) {
        if (cur == null) return;
        inOrder(nums, cur.left);
        nums.add(cur.val);
        inOrder(nums, cur.right);
    }
}