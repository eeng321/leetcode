class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (prices == null || len < 2) return 0;
        
        Integer min = null, max = null;
        int ans = 0;
        for(int i = len - 1; i >= 0; i--) {
            if (max == null || prices[i] > max) {
                max = prices[i];
                min = prices[i];
            } else if (min == null || prices[i] < min) {
                min = prices[i];
                ans = Math.max(max - min, ans);
            }
        }
        return ans;
    }
}