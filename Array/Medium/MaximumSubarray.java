import java.util.Scanner;

// https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                max = Math.max(max, sum);
            }
        }

        // Approach 2 - Kadane's Algorithm
        // Time Complexity - O(n)     Space Complexity - O(1)
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
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

        System.out.print(maxSubArray(nums));
        scanner.close();
    }
}

/*
Test Case - 1
Input:-
9
-2 1 -3 4 -1 2 1 -5 4
Output:-
6


Test Case - 2
Input:-
7
3 -4 5 4 -1 7 -8
Output:-
15


Test Case - 3
Input:-
5
5 4 -1 7 8
Output:-
23
*/