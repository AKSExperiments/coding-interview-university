package interviews;

public class stock_buy_sell {

    public static int maxProfit(int[] price) {
        // iterate over price, buy only if the next day has a value greater than current
        // if the next day has a price lower than the current and the day next to it is higher, then the above logic ensures I get the max still
        int maxProfit = 0;
        for(int i = 0; i < price.length-1; i++) {
            if(price[i] >= price[i+1]) {
                continue;
            }
            maxProfit = maxProfit - price[i] + price[i+1];
        }
        return Math.max(0, maxProfit);
    }

    public static void main(String[] args) {
        int[] price = {100, 180, 260, 310, 40, 535, 695};
        System.out.print("~~~~~1");
        System.out.print(maxProfit(price));
        int[] price2 = {100, 90, 80, 70, 40, 30, 10};
        System.out.print("~~~~~2");
        System.out.print(maxProfit(price2));
    }
}
