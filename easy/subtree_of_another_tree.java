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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null) continue;
            if(curr.val == t.val) {
                if(isEqual(curr,t)) return true;
            }
            q.add(curr.left);
            q.add(curr.right);
        }
        return false;
    }
    
    private boolean isEqual(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        
        return t1.val == t2.val && isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
    }
}