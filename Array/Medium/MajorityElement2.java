import java.util.*;

// https://leetcode.com/problems/majority-element-ii/
public class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > n / 3 && !ans.contains(nums[i])) {
                ans.add(nums[i]);
            }
        }

        // Approach 2 - HashMap (Better)
        // Time Complexity - O(n)     Space Complexity - O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > n / 3 && !ans.contains(key)) {
                ans.add(key);
            }
        }

        // Approach 3 - Boyer-Moore Voting Algorithm (Best)
        // Time Complexity - O(n)     Space Complexity - O(1)
        int candidate1 = nums[0], candidate2 = nums[0];
        int count1 = 0, count2 = 0;
        for (int current : nums) {
            if (candidate1 == current) {
                count1++;
            } else if (candidate2 == current) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = current;
                count1++;
            } else if (count2 == 0) {
                candidate2 = current;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        
        for (int current : nums) {
            if (candidate1 == current) {
                count1++;
            } else if (candidate2 == current) {
                count2++;
            }
        }

        if (count1 > n / 3) {
            ans.add(candidate1);
        } if (count2 > n / 3) {
            ans.add(candidate2);
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

        List<Integer> answers = majorityElement(nums);
        for (int ans : answers) {
            System.out.print(ans + " ");
        }
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
1
1
Output:-
1


Test Case - 3
Input:-
2
1 2
Output:-
1 2
*/