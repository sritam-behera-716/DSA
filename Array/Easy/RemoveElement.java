import java.util.Scanner;

// https://leetcode.com/problems/remove-element/description/
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        // Approach 1 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(1)
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[start] = nums[i];
                start++;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int val = scanner.nextInt();

        int ans = removeElement(nums, val);
        System.out.print(ans);
    }
}

/*
Test Case - 1
Input:-
4
3 2 2 3
3
Output:-
2


Test Case - 2
Input:-
8
0 1 2 2 3 0 4 2
2
Output:-
5
*/