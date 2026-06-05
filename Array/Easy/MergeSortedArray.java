import java.util.Scanner;

// https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Approach 1 - Brute Force
        // Time Complexity - O(m + n)     Space Complexity - O(m + n)
        int i = 0, j = 0, k = 0;
        int[] res = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }

        while (i < m) {
            res[k++] = nums1[i++];
        }

        while (j < n) {
            res[k++] = nums2[j++];
        }

        for (i = 0; i < res.length; i++) {
            nums1[i] = res[i];
        }

        // Approach 2 - Move From Back
        // Time Complexity - O(m + n)     Space Complexity - O(1)
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];
        for (int i = 0; i < m + n; i++) {
            nums1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }

        merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}

/*
Test Case - 1
Input:-
3
3
1 2 3 0 0 0
2 5 6
Output:-
1 2 2 3 5 6


Test Case - 2
Input:-
4
4
11 33 42 71 0 0 0 0
26 54 69 81
Output:-
11 26 33 42 54 69 71 81 
*/