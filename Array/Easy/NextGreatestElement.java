import java.util.Scanner;

public class NextGreatestElement {
    public static int[] nextGreatestElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[n - 1] = -1;

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < n - 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                max = Math.max(nums[j], max);
            }
            ans[i] = max;
        }

        // Approach 2 - Move From Back
        // Time Complexity - O(n)     Space Complexity - O(1)
        int max = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(nums[i + 1], max);
            ans[i] = max;    
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
        
        int[] ans = nextGreatestElement(nums);
        for (int i: ans) {
            System.out.print(i + " ");
        }
        scanner.close();
    } 
}

/*
Test Case - 1
Input:-
9
12 8 41 37 2 49 16 28 21
Output:-
49 49 49 49 49 28 28 21 -1


Test Case - 2
Input:-
5
4 5 2 10 8
Output:-
10 10 10 8 -1
*/