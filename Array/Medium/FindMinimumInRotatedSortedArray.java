import java.util.Scanner;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        // Approach 1 - Brute Force
        // Time Complexity - O(n)     Space Complexity - O(1)
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }

        // Approach 1 - Binary Search
        // Time Complexity - O(log(n))     Space Complexity - O(1)
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start]; // return mind for 1st approach
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(findMin(nums));
    }
}

/*
Test Case - 1
Input:-
5
3 4 5 1 2
Output:-
1


Test Case - 2
Input:-
7
4 5 6 7 0 1 2
Output:-
0


Test Case - 3
Input:-
4
11 13 15 17
Output:-
11
*/