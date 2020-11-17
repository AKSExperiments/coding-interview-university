package interviews;

public class minCoins {
        static int minCoins(int[] coins, int value, int[] dp) { // coins, 25
            if(value < 0) {
                return -1;
            }
            if(value == 0)
            {
                return 0;
            }
            // iterate over coins
            // value < coin[i]
            // minCoins(coins, value - coins[i])
            // count++
            if(dp[value - 1] != 0) {
                return dp[value - 1];
            }
            int count = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++) {
                if(coins[i] <= value) {
                    int tempCount = minCoins(coins, value - coins[i], dp);
                    if(tempCount >= 0 && tempCount < count) {
                        count = tempCount + 1;
                    }
                    if(count != Integer.MAX_VALUE) {
                        dp[value - 1] = count;
                    }else  {
                        dp[value -1] = -1;
                    }
                }
            }
            return dp[value-1];
        }

        public static void main(String[] args) {
            int[] coins = {11,9,7,5,1};
            int value = 150;
            System.out.println(minCoins(coins, value, new int[value]));
        }
}
