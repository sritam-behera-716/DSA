import java.util.*;

// https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        // Approach 2 - HashMap
        // Time Complexity - O(n)     Space Complexity - O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}