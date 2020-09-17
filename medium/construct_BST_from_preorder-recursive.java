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
        int len = preorder.length;
        if(len == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < len; i++){
            insert(root, preorder[i]);
        }
        return root;
    }
    
    public TreeNode insert(TreeNode node, int n) {
        if(node == null) {
            return new TreeNode(n);
        }
        if(node.val > n){
            if(node.left == null) {
                node.left = insert(node.left, n);
            } else {
                return insert(node.left, n);
            }
        } else if (node.val < n){
            if(node.right == null) {
                node.right = insert(node.right, n);
            } else {
                return insert(node.right, n);
            }
        }
        return null;
    }
}