import java.util.*;

// https://leetcode.com/problems/contains-duplicate?envType=problem-list-v2&envId=array
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        
        // Approach 2 - HashSet
        // Time Complexity - O(n)     Space Complexity - O(n)
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
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

        System.out.println(containsDuplicate(nums));
        scanner.close();
    }
}

/*
Test Case - 1
Input:-
4
1 2 3 1
Output:-
true


Test Case - 2
Input:-
4
1 2 3 4
Output:-
false


Test Case - 3
Input:-
10
1 1 1 3 3 4 3 2 4 2
Output:-
true
*/