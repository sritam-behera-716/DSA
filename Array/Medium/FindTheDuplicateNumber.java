import java.util.Scanner;

// https://leetcode.com/problems/find-the-duplicate-number/
public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int n = nums.length;

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i : nums) {
            int count = 0;
            for (int j : nums) {
                if (i == j) {
                    count++;
                }
            }

            if (count >= 2) {
                return i;
            }
        }

        return 0;
    }        

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(findDuplicate(nums));
    }
}

/*
Test Case - 1
Input:-
5
1 3 4 2 2
Output:-
2


Test Case - 2
Input:-
5
3 1 3 4 2
Output:-
3


Test Case - 3
Input:-
5
3 3 3 3 3
Output:-
3
*/
