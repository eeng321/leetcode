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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null) continue;
            invert(curr);
            
            q.add(curr.left);
            q.add(curr.right);
        }
        return root;
    }
    
    private void invert(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}