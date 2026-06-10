import java.util.*;

// https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicate2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }

        // Approach 2 - HashMap
        // Time Complexity - O(n)     Space Complexity - O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        // Approach 3 - HashSet
        // Time Complexity - O(n)     Space Complexity - O(k)
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
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
        int k = scanner.nextInt();

        System.out.println(containsNearbyDuplicate(nums, k));
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