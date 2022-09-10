package dynamicprogramming;
public class BuyAndSell4 {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2)
            return maxProfit(prices);
        int dp[][] = new int[k + 1][prices.length];
        for (int i = 1; i < dp.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < dp[0].length; j++) {
                maxDiff = Math.max(maxDiff, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
            }
        }
        return dp[k][prices.length - 1];
    }
    private int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        int prices[]={3,2,6,5,0,3};
        int k=2;
        BuyAndSell4 ob=new BuyAndSell4();
        System.out.println(ob.maxProfit(k,prices));
    }
}


