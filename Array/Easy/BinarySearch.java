import java.util.Scanner;

// https://leetcode.com/problems/binary-search/description/
public class BinarySearch {
    public static int search(int[] nums, int target) {
        // Time Complexity - O(log(n))
        // Space Complexity - O(1)

        int low = 0, high = nums.length -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
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
6
-1 0 3 5 9 12
9
Output:-
4


Test Case - 2
Input:-
6
-1 0 3 5 9 12
2
Output:-
-1
*/