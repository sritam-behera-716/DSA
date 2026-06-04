import java.util.Scanner;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSum2 {
    public static int[] twoSum(int[] numbers, int target) {
        // Approach 1 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(1)
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        int[] ans = twoSum(numbers, target);
        System.out.print(ans[0] + " " + ans[1]);
    }
}

/*
Test Case - 1
Input:-
4
2 7 11 15
9
Output:-
1 2


Test Case - 2
Input:-
3
2 3 4
6
Output:-
1 3


Test Case - 3
Input:-
2
-1 0
-1
Output:-
1 2
*/