import java.util.Scanner;

// https://leetcode.com/problems/sort-colors/
public class SortColors {
    public static void sortZerosOnesTwos(int[] nums) {
        // Approach 1 - Counting
        // Time Complexity - O(n)     Space Complexity - O(1)
        // int zero = 0, one = 0;
        // for (int num : nums) {
        //     if (num == 0) {
        //         zero++;
        //     } else if (num == 1) {
        //         one++;
        //     }
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     if (i < zero) {
        //         nums[i] = 0;
        //     } else if (i < zero + one) {
        //         nums[i] = 1;
        //     } else {
        //         nums[i] = 2;
        //     }
        // }

        // Approach 2 - Dutch National Flag algorithm
        // Time Complexity - O(n)     Space Complexity - O(1)
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        sortZerosOnesTwos(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

/*
Test Case - 1
Input:-
6
2 0 2 1 1 0
Output:-
0 0 1 1 2 2


Test Case - 2
Input:-
10
0 1 2 0 1 2 1 2 0 0
Output:-
0 0 0 0 1 1 1 2 2 2


Test Case - 3
Input:-
3
2 0 1
Output:-
0 1 2 
*/