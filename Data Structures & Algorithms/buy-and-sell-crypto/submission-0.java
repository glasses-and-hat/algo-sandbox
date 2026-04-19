class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        //brute force
        // for(int i=0; i<prices.length;i++) {
        //     for(int j = i+1; j< prices.length; j++) {
        //         profit = Math.max(profit, prices[j] - prices[i]);
        //     }
        // }

        // Something other than brute force
        int buyPrice = prices[0];
        for(int i =1; i< prices.length; i++) {
            profit = Math.max(profit, prices[i] - buyPrice);
            buyPrice = Math.min(buyPrice, prices[i]);
        }
        return profit;
    }
}
