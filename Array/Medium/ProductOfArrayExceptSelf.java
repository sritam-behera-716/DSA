import java.util.Scanner;

// https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product = product * nums[j];
                }
            }
            ans[i] = product;
        }

        // Approach 2 - Prefix + Suffix Arrays
        // Time Complexity - O(n)     Space Complexity - O(n)
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = suffix[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        // Approach 3 - Without Prefix & Suffix Arrays
        // Time Complexity - O(n)     Space Complexity - O(1) 
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix = suffix * nums[i + 1];
            ans[i] = ans[i] * suffix;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] answers = productExceptSelf(nums);
        for (int answer : answers) {
            System.out.print(answer + " ");
        }
    }
}

/*
Test Case - 1
Input:-
4
1 2 3 4
Output:-
24 12 8 6


Test Case - 2
Input:-
5
-1 -1 0 -3 -3
Output:-
0 0 9 0 0
*/
