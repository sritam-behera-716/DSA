import java.util.Scanner;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - buy);
            }
        }

        // Approach 2 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(1)
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
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
5


Test Case - 2
Input:-
5
7 6 4 3 1
Output:-
0
*/