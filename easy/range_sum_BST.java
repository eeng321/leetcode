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
    public int rangeSumBST(TreeNode root, int L, int R) {
        return getSum(root, L, R);
    }
    
    public int getSum(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val >= L && root.val <= R) {
            return root.val + getSum(root.left, L, R) + getSum(root.right, L, R);
        } else if (root.val < L){
            return getSum(root.right, L, R);
        } else if (root.val > R) {
            return getSum(root.left, L, R);
        }
        return 0;
    }
}