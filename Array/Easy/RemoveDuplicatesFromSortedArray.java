import java.util.*;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=problem-list-v2&envId=array
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        // Approach 1 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(1)
        int start = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
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

        int k = removeDuplicates(nums);
        System.out.print(k);
    }
}

/*
Test Case - 1
Input:-
3
1 1 2
Output:-
2


Test Case - 2
Input:-
10
0 0 1 1 1 2 2 3 3 4
Output:-
5
*/