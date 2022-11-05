package algorithms.classic;

public class Knapsack {

    public static int getMaxValue(int[] values, int[] costs, int targetValue) {
        int[][] dp = new int[values.length + 1][targetValue + 1];
        for (int i = 0; i <= values.length; i++) {
            for (int j = 0; j <= targetValue; j++) {
                dp[i][j] = -1;
            }
        }
        return getMaxValueRecursive(0, targetValue, values, costs, dp);
    }

    private static int getMaxValueRecursive(int index, int amount, int[] values, int[] costs, int[][] dp) {
        if (index >= values.length) return 0;

        if (amount <= 0) return Integer.MIN_VALUE;

        if (dp[index][amount] != -1)
            return dp[index][amount];

        int currentValue = values[index];

        int take = currentValue + getMaxValueRecursive(index + 1, amount - costs[index], values, costs, dp);
        int notTake = getMaxValueRecursive(index + 1, amount, values, costs, dp);

        dp[index][amount] = Integer.max(take, notTake);
        return dp[index][amount];
    }
}
