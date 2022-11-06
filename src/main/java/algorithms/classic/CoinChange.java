package algorithms.classic;

public class CoinChange {

    public static int getMinimumChanges(int[] coins, int targetValue) {
        int[][] dp = new int[coins.length + 1][targetValue + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= targetValue; j++) {
                dp[i][j] = -1;
            }
        }
        int minimumChanges = getMinimumChangesRecursive(0, targetValue, coins, dp);
        if (minimumChanges >= dp[0].length) return -1;
        return minimumChanges;
    }

    private static int getMinimumChangesRecursive(int index, int amount, int[] coins, int[][] dp) {
        if (index >= coins.length || amount < 0) return dp[0].length;

        if (amount == 0) return 0;

        if (dp[index][amount] != -1)
            return dp[index][amount];

        int currentCoin = coins[index];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i * currentCoin <= amount; i++) {
            int newAmount = amount - (i * currentCoin);
            int result = i + getMinimumChangesRecursive(index + 1, newAmount, coins, dp);
            min = Integer.min(min, result);
        }
        dp[index][amount] = min;
        return min;
    }
}
