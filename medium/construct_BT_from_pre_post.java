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
    int i = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, post, 0, pre.length - 1);
    }
    
    public TreeNode helper(int[] pre, int[] post, int s, int e) {
        if(s > e) return null;
        TreeNode cur = new TreeNode(pre[i++]);
        if(s == e) return cur;
        
        int mid = s;
        while(post[mid] != pre[i]){
            mid++;
        }
        cur.left = helper(pre,post,s,mid);
        cur.right = helper(pre,post,mid+1, e-1);
        return cur;
    }
}