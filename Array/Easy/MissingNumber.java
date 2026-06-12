import java.util.Scanner;

// https://leetcode.com/problems/missing-number/?envType=problem-list-v2&envId=array
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;

        // Approach 1 - Brute Force
        // Time Complexity - O(n)     Space Complexity - O(n)
        int[] arr = new int[n + 1];
        for (int num : nums) {
            arr[num] = 1;
        }

        for (int i = 0; i <= n; i++) {
            if (arr[i] == 0) {
                return i;
            }
        }

        // Approach 2 - Calculation
        // Time Complexity - O(n)     Space Complexity - O(1)
        int totalSum = n * (n + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }

        return totalSum - sum; // Return -1 for first approach
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int miss = missingNumber(nums);
        System.out.print(miss);
        scanner.close();
    }
}

/*
Test Case - 1
Input:-
3
3 0 1
Output:-
2


Test Case - 2
Input:-
2
0 1
Output:-
2


Test Case - 3
Input:-
9
9 6 4 2 3 5 7 0 1
Output:-
8
*/