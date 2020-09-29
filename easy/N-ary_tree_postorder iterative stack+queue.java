/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if(root == null) return ans;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            Node curr = s.pop();
            if(curr == null) continue;
            ans.addFirst(curr.val);
            for(Node n : curr.children) {
                s.push(n);
            }
        }
        return ans;
    }
}