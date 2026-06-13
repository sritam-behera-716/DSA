import java.util.*;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;

        // Approach 1 - Linear Search
        // Time Complexity - O(n)     Space Complexity - O(1)
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        // Approach 2 - Modified Binary Search
        // Time Complexity - O(log (n))     Space Complexity - O(1)
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        System.out.print(search(nums, target));
    }
}

/*
Test Case - 1
Input:-
7
4 5 6 7 0 1 2
0
Output:-
4


Test Case - 2
Input:-
7
4 5 6 7 0 1 2
3
Output:-
-1


Test Case - 3
Input:-
1
1
0
Output:-
-1
*/