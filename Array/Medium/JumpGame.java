import java.util.Scanner;

// https://leetcode.com/problems/jump-game/
public class JumpGame {
    public static boolean canJump(int[] nums) {
        // Approach 1 - Greedy
        // Time Complexity - O(n)     Space Complexity - O(1)
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print(canJump(nums));
    }
}

/*
Test Case - 1
Input:-
5
2 3 1 1 4
Output:-
true


Test Case - 2
Input:-
5
3 2 1 0 4
Output:-
false

Test Case - 3
Input:-
4
2 5 0 0
Output:-
true
*/