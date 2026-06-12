import java.util.*;

// https://leetcode.com/problems/third-maximum-number/?envType=problem-list-v2&envId=array
public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        // Approach 1 - Sorting
        // Time Complexity - O(n * log(n))     Space Complexity - O(1)
        Arrays.sort(nums);

        int n = nums.length;
        int start = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[start] = nums[i];
                start++;
            }
        }

        if (start - 3 < 0) {
            return nums[n - 1];
        } else {
            return nums[start - 3];
        }

        // Approach 2 - Three Variables
        // Time Complexity - O(n)     Space Complexity - O(1)
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for (int num : nums) {
            if(num == max1 || num == max2 || num == max3) {
                continue;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = (long) num;
            } else if (num > max2 && num != max1) {
                max3 = max2;
                max2 = (long) num;
            } else if (num > max3 && num != max2 && num != max1) {
                max3 = (long) num;
            }
        }

        return max3 == Long.MIN_VALUE ? (int) max1 : (int) max3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(thirdMax(nums));
    }
}

/*
Test Case - 1
Input:-
3
3 2 1
Output:-
1


Test Case - 2
Input:-
2
1 2
Output:-
2


Test Case - 3
Input:-
4
2 2 3 1
Output:-
1

Test Case - 4
Input:-
9
3 2 3 1 2 4 5 5 6
Output:-
4
*/