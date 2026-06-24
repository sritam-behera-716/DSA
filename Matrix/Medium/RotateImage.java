import java.util.Scanner;

// https://leetcode.com/problems/rotate-image/description/
public class RotateImage {
    public static void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(n^2)
        int[][] transpose = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][c - 1 - j] = transpose[i][j];
            }
        }

        // Approach 2 - Transpose + Reverse
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < r; i++) {
            int start = 0, end = c - 1;
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        rotate(matrix);
        for (int[] row : matrix) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}

/*
Test Case - 1
Input:-
3 3
1 2 3
4 5 6
7 8 9
Output:-
7 4 1
8 5 2
9 6 3


Test Case - 2
Input:-
4 4
5 1 9 11
2 4 8 10
13 3 6 7
15 14 12 16
Output:-
15 13 2 5
14 3 4 1
12 6 8 9
16 7 10 11
*/