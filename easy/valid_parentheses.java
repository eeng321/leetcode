class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1) return false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(isOpenBracket(c)){
                stack.push(c);
            } else {
                if(!stack.empty() && isMatching(stack.peek(), c)){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
    
    public boolean isOpenBracket(char c) {
        return c == '{' || c == '(' || c == '[';   
    }
    
    public boolean isMatching(char o, char c) {
        if(o == '(' && c == ')') {
            return true;
        }
        if(o == '{' && c == '}') {
            return true;
        }
        if(o == '[' && c == ']') {
            return true;
        }
        return false;
    }
}