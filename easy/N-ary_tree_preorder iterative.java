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
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> s = new Stack<>();
        s.push(root);
        
        while(!s.isEmpty()){
            Node curr = s.pop();
            if(curr == null) continue;
            ans.add(curr.val);
            int len = curr.children.size();
            for(int i = len - 1; i >= 0; i--){
                s.push(curr.children.get(i));
            }
        }
        return ans;
    }
}