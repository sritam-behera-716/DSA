import java.util.Scanner;

// https://leetcode.com/problems/maximum-product-subarray/description/
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        
        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product = product * nums[j];
                max = Math.max(max, product);
            }
        }

        // Approach 2 - Prefix + Suffix
        // Time Complexity - O(n)     Space Complexity - O(1)
        int prefix = 1, suffix = 1;
        for (int i = 0; i < n; i++) {
            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            max = Math.max(max, prefix);
            max = Math.max(max, suffix);

            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(maxProduct(nums));
    }
}

/*
Test Case - 1
Input:-
4
2 3 -2 4
Output:-
6


Test Case - 2
Input:-
3
-2 0 -1
Output:-
0
*/