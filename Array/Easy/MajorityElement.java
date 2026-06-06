import java.util.*;

// https://leetcode.com/problems/majority-element/description/
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i : nums) {
            int count = 0;
            for (int j : nums) {
                if (i == j) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return i;
            }
        }

        // Approach 2 - HashMap (Better)
        // Time Complexity - O(n)     Space Complexity - O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            int value = map.getOrDefault(key, 0);
            if (value + 1 > nums.length / 2) {
                return key;
            }
            if (value == 0) {
                map.put(key, 1);
            } else {
                map.replace(key, value + 1);
            }
        }

        // Approach 3 - Boyer-Moore Voting Algorithm (Best)
        // Time Complexity - O(n)     Space Complexity - O(1)
        int candidate = nums[0];
        int count = 0;
        for (int current : nums) {
            if (candidate == current) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = current;
                    count++;
                }
            }
        }
        
        return candidate; // return -1 for above two approaches
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(majorityElement(nums));
        scanner.close();
    }
}

/*
Test Case - 1
Input:-
3
3 2 3
Output:-
3


Test Case - 2
Input:-
7
2 2 1 1 1 2 2
Output:-
2
*/