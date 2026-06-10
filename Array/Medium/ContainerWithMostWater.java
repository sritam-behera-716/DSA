import java.util.Scanner;

// https://leetcode.com/problems/container-with-most-water/description/?envType=problem-list-v2&envId=array
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int n = height.length;
        int max = 0;

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int area = minHeight * (j - i);
                if (area > max) {
                    max = area;
                }
            }
        }

        // Approach 2 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(1)
        int i = 0, j =  n - 1;
        while (i < j) {
            int leftHeight = height[i];
            int rightHeight = height[j];
            int distance = j - i;

            if (leftHeight < rightHeight) {
                max = Math.max(max, leftHeight * distance);
                i++;
            } else {
                max = Math.max(max, rightHeight * distance);
                j--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }

        int max = maxArea(height);
        System.out.print(max);
    }
}

/*
Test Case - 1
Input:-
9
1 8 6 2 5 4 8 3 7
Output:-
49


Test Case - 2
Input:-
2
1 1
Output:-
1
*/