import java.util.Scanner;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfit = maxProfit + prices[i + 1] - prices[i];
            }
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        int profit = maxProfit(prices);
        System.out.print(profit);
    }
}

/*
Test Case - 1
Input:-
6
7 1 5 3 6 4
Output:-
7


Test Case - 2
Input:-
5
1 2 3 4 5
Output:-
4


Test Case - 3
Input:-
5
7 6 4 3 1
Output:-
0
*/