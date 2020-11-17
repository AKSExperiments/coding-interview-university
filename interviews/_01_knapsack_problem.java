package interviews;

public class _01_knapsack_problem {
    // recursive approach
    public static int recKnapsack(int[] profits, int[] weights, int capacity, int currentIndex) {
        if(capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }
        int profit1 = 0;
        if (capacity >=  weights[currentIndex]) {
            profit1 = profits[currentIndex] + recKnapsack(profits, weights, capacity - weights[currentIndex], currentIndex+1);
        }
        int profit2 = recKnapsack(profits, weights, capacity, currentIndex+1);
        return Math.max(profit1, profit2);
    }

    // DP approach
    public static int dpKnapsack(int[] profits, int[] weights, Integer[][] dp, int capacity, int currentIndex) {
        if(capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }
        if(dp[capacity][currentIndex] != null) {
            return dp[capacity][currentIndex];
        }
        int profit1 = 0;
        if (capacity >=  weights[currentIndex]) {
            profit1 = profits[currentIndex] + dpKnapsack(profits, weights, dp, capacity - weights[currentIndex], currentIndex+1);
        }
        int profit2 = dpKnapsack(profits, weights, dp, capacity, currentIndex+1);
        dp[capacity][currentIndex] = Math.max(profit1, profit2);
        return dp[capacity][currentIndex];
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;
        int maxProfit = recKnapsack(profits, weights, capacity, 0);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        Integer[][] dp = new Integer[capacity+1][profits.length];
        maxProfit = dpKnapsack(profits, weights, dp, capacity, 0);
        System.out.println("Total knapsack profit ---> " + maxProfit);

    }
}
