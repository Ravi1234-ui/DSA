class Solution {
    int[][] dp;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int p1 = solve(0, n - 1, piles);

        int total = 0;
        for (int x : piles)
            total += x;

        return p1 > total - p1;
    }

    private int solve(int i, int j, int[] piles) {
        if (i > j) return 0;
        if (i == j) return piles[i];

        if (dp[i][j] != -1)
            return dp[i][j];

        int takeLeft = piles[i] + Math.min(
                solve(i + 2, j, piles),
                solve(i + 1, j - 1, piles)
        );

        int takeRight = piles[j] + Math.min(
                solve(i, j - 2, piles),
                solve(i + 1, j - 1, piles)
        );

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }
}