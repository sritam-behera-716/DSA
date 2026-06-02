import java.util.Scanner;

// https://leetcode.com/problems/rotate-array/description/
public class RotateArray {
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // Approach 1 - Brute Force
        // Time Complexity - O(n*k)     Space Complexity - O(1)
        while (k != 0) {
            int temp = nums[n - 1];
            for (int i = n - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }

        // Approach 2 - Reversal Algorithm
        // Time Complexity - O(n)     Space Complexity - O(1)
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        rotate(nums, k);
        for (int item : nums) {
            System.out.print(item + " ");
        }
    }
}

/*
Test Case - 1
Input:-
7
1 2 3 4 5 6 7
3
Output:-
5 6 7 1 2 3 4


Test Case - 2
Input:-
4
-1 -100 3 99
2
Output:-
3 99 -1 -100


Test Case - 3
Input:-
7
1 2 3 4 5 6 7
10
Output:-
5 6 7 1 2 3 4
*/