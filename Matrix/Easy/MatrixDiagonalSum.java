import java.util.Scanner;

// https://leetcode.com/problems/matrix-diagonal-sum/description/
public class MatrixDiagonalSum {
    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    sum += mat[i][j];
                }
            }
        }

        // Approach 2 - Both side
        // Time Complexity - O(n)     Space Complexity - O(1)
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - i - 1];
        }

        if (n % 2 != 0) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        System.out.println(diagonalSum(matrix));
        scanner.close();
    }
}

/*
Test Case - 1
Input:-
3
1 2 3
4 5 6
7 8 9
Output:-
25


Test Case - 2
Input:-
4
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
Output:-
8
*/