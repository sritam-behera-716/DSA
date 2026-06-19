import java.util.*;

// https://www.geeksforgeeks.org/problems/pair-sum-in-a-sorted-and-rotated-array/1
public class PairSumInSortedAndRotatedArray {
    public static boolean pairInSortedRotated(int nums[], int target) {
        // Approach 1 - HashSet
        // Time Complexity - O(n)     Space Complexity - O(n)
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            int need = target - num;
            if (set.contains(need)) {
                return true;
            }
            set.add(num);
        }

        // Approach 2 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(1)
        int n = nums.length;
        int pivot = -1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i + 1;
                break;
            }
        }

        if (pivot == -1) {
            pivot = 0;
        }

        int start = pivot;
        int end = (pivot - 1 + n) % n;

        while (start != end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                start = (start + 1) % n;
            } else {
                end = (end - 1 + n) % n;
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

        System.out.println(pairInSortedRotated(nums, target));
    }
}

/*
Test Case - 1
Input:-
5
7 9 1 3 5
6
Output:-
true


Test Case - 2
Input:-
4
2 3 4 1
3
Output:-
true


Test Case - 3
Input:-
4
10 7 4 1
9
Output:-
false
*/