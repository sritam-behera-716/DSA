import java.util.*;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class SearchInRotatedSortedArray2 {
     public static boolean search(int[] nums, int target) {
        int n = nums.length;

        // Approach 1 - Linear Search
        // Time Complexity - O(n)     Space Complexity - O(1)
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return true;
            }
        }

        // Approach 2 - Modified Binary Search
        // Time Complexity - O(log (n))     Space Complexity - O(1)
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
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

        return false;
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
2 5 6 0 0 1 2
0
Output:-
true


Test Case - 2
Input:-
7
2 5 6 0 0 1 2
3
Output:-
false


Test Case - 3
Input:-
5
1 0 1 1 1
0
Output:-
true


Test Case - 4
Input:-
3
1 2 1
1
Output:-
true
*/