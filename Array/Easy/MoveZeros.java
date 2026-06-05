import java.util.Scanner;

// https://leetcode.com/problems/move-zeroes/description/
public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        // Approach 1 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(1)
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

/*
Test Case - 1
Input:-
5
0 1 0 3 12
Output:-
1 3 12 0 0


Test Case - 2
Input:-
8
4 5 0 1 9 0 5 0
Output:-
4 5 1 9 5 0 0 0 


Test Case - 3
Input:-
6
6 0 1 8 0 2
Output:-
6 1 8 2 0 0
*/