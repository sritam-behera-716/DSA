import java.util.*;

// https://leetcode.com/problems/single-number/description/?envType=problem-list-v2&envId=array
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int n = nums.length;

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count == 1) {
                return nums[i];
            }
        }

        // Approach 2 - HashMap
        // Time Complexity - O(n)     Space Complexity - O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        // // Approach 3 - XOR Operator
        // // Time Complexity - O(n)     Space Complexity - O(1)
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(singleNumber(nums));
    }
}

/*
Test Case - 1
Input:-
3
2 2 1
Output:-
1


Test Case - 2
Input:-
5
4 1 2 1 2
Output:-
4


Test Case - 3
Input:-
11
9 8 6 4 2 5 6 2 4 8 9
Output:-
5
*/
