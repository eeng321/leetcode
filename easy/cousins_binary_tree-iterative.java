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
class Node {
    int depth;
    TreeNode parent;
    
    Node(int depth, TreeNode parent){
        this.depth = depth;
        this.parent = parent;
    }
}

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        Node nodeX = null, nodeY = null;
        int d = 0; // depth
        while(!q.isEmpty() && nodeX == null && nodeY == null) {
            int size = q.size();
            d++;
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr == null) continue;
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                if(left != null) {
                    if(left.val == x) {
                        nodeX = new Node(d, curr);
                    } else if(left.val == y) {
                        nodeY = new Node(d, curr);
                    }
                    q.add(left);
                }
                if(right != null) {
                    if(right.val == x) {
                        nodeX = new Node(d, curr);
                    } else if(right.val == y) {
                        nodeY = new Node(d, curr);
                    }
                    q.add(right);
                }
            }
        }
        return checkIfCousin(nodeX, nodeY);
    }
    
    private boolean checkIfCousin(Node x, Node y) {
        if(x == null || y == null) return false;
        if(y.parent.val == x.parent.val) return false;
        if(x.depth != y.depth) return false;
        return true;
    }
}