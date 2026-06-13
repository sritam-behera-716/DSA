import java.util.*;

// https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
public class ChocolateDistribution {
    public static int findMinDiff(int chocos[], int m) {
        int n = chocos.length;

        Arrays.sort(chocos);
        int minDiff = Integer.MAX_VALUE;

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i <= n - m; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < i + m; j++) {
                max = Math.max(max, chocos[j]);
                min = Math.min(min, chocos[j]);
            }
            minDiff = Math.min(minDiff, max - min);
        }

        // Approach 2 - Sliding Window
        // Time Complexity - O(n * log(n))     Space Complexity - O(1)
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = chocos[i + m - 1] - chocos[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] chocos = new int[n];
        for (int i = 0; i < n; i++) {
            chocos[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();

        System.out.print(findMinDiff(chocos, m));
    }
}

/*
Test Case - 1
Input:-
8
3 4 1 9 56 7 9 12
5
Output:-
6


Test Case - 2
Input:-
7
7 3 2 4 9 12 56
3
Output:-
2


Test Case - 3
Input:-
5
3 4 1 9 56
5
Output:-
55
*/