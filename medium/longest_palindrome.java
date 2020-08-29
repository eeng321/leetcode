class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            int len1 = getLongestPalindrome(s,i,i);
            int len2 = getLongestPalindrome(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > right-left){
                left = i - (len-1)/2;
                right = i + len/2;
                if(len == s.length()){
                    break;
                }
            }
        }
        return s.substring(left, right + 1); // the + 1 is to include the letter in the 'right' pointer index
    }
    
    private int getLongestPalindrome(String s, int left, int right) {
        if(s == null || left > right) return 0;
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}