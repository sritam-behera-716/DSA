import java.util.*;

// https://leetcode.com/problems/set-mismatch/description/?envType=problem-list-v2&envId=array
public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        // Approach 1 - Brute Force
        // Time Complexity - O(n)     Space Complexity - O(n)
        int n = nums.length;
        int repeat = -1, missing = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            int value = map.getOrDefault(i, 0);
            if (value == 0) {
                missing = i;
            } else if (value == 2) {
                repeat = i;
            }
        }
        
        return new int[]{repeat, missing};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] ans = findErrorNums(nums);
        System.out.print(ans[0] + " " + ans[1]);
        scanner.close();
    }
}

/*
Test Case - 1
Input:-
4
1 2 2 4
Output:-
2 3


Test Case - 2
Input:-
2
1 1
Output:-
1 2


Test Case - 3
Input:-
2
2 2
Output:-
2 1
*/