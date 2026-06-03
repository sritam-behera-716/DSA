import java.util.Scanner;

// https://www.naukri.com/code360/problems/sort-0-1_624379
public class SortZerosOnes {
    public static void sortZerosOnes(int[] nums) {
        // Approach 1 - Counting
        // Time Complexity - O(n)     Space Complexity - O(1)
        int zero = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < zero) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }

        // Approach 2 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(1)
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] == 0) {
                i++;
            } else if (nums[j] == 1) {
                j--;
            } else {
                nums[i] = 0;
                nums[j] = 1;
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        sortZerosOnes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

/*
Test Case - 1
Input:-
6
1 0 1 0 0 1
Output:-
0 0 0 1 1 1


Test Case - 2
Input:-
5
1 0 1 0 1
Output:-
0 0 1 1 1


Test Case - 3
Input:-
6
1 1 1 0 0 0
Output:-
0 0 0 1 1 1
*/