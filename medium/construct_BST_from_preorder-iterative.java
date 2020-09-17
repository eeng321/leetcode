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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            insert(root, preorder[i]);
        }
        return root;
    }
    
    public void insert(TreeNode node, int n) {
        if (node == null) return;

        while(true) {
            if(node.val > n) {
                if (node.left != null){
                    node = node.left;
                } else {
                    node.left = new TreeNode(n);
                    return;
                }
            } else if(node.val < n) {
                if (node.right != null){
                    node = node.right;
                } else {
                    node.right = new TreeNode(n);
                    return;
                }
            }
        }
    }
}