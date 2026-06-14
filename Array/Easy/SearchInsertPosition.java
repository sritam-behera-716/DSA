import java.util.Scanner;

// https://leetcode.com/problems/search-insert-position/description/?envType=problem-list-v2&envId=array
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;

        // Approach 1 - Linear Search
        // Time Complexity - O(n)     Space Complexity - O(1)
        int i = -1;
        for (i = 0; i < n; i++) {
            if (nums[i] == target || target < nums[i]) {
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
            } else if (start == end && nums[mid] < target) {
                return mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start; // return i for 1st approach
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        System.out.print(searchInsert(nums, target));
    }
}

/*
Test Case - 1
Input:-
4
1 3 5 6
5
Output:-
2


Test Case - 2
Input:-
4
1 3 5 6
2
Output:-
1


Test Case - 3
Input:-
4
1 3 5 6
7
Output:-
4


Test Case - 3
Input:-
4
1 3 5 6
0
Output:-
0
*/