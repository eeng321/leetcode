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
    int sumTilt = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        sum(root);
        return sumTilt;
    }
    
    private int sum(TreeNode root) {
        if(root == null) return 0;
        int sumL = sum(root.left);
        int sumR = sum(root.right);
        sumTilt += Math.abs(sumL - sumR);
        return root.val + sumL + sumR;
    }
}