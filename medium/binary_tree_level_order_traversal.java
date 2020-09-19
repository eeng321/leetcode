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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // push node onto queue
        // while queue not empty, push children of nodes into queue
        // for each iteration poll #times == size of queue and store in list
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> lvl = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode n = q.poll();
                if(n.left != null) {
                    q.add(n.left);
                }
                if(n.right != null) {
                    q.add(n.right);   
                }
                lvl.add(n.val);
            }
            ans.add(lvl);
        }
        return ans;
    }
}