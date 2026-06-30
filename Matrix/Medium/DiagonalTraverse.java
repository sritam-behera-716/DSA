import java.util.Scanner;

// https://leetcode.com/problems/diagonal-traverse/description/
public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        // Approach 1 - Simulation
        // Time Complexity - O(m * n)     Space Complexity - O(1)
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];

        int row = 0, col = 0;
        for (int i = 0; i < m * n; i++) {
            ans[i] = mat[row][col];
            if ((row + col) % 2 == 0) {
                if (col == n - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                }  else {
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] answers = findDiagonalOrder(matrix);
        for (int ans : answers) {
            System.out.print(ans + " ");
        }
        scanner.close();
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
1 2 4 7 5 3 6 8 9


Test Case - 2
Input:-
2 2
1 2
3 4
Output:-
1 2 3 4
*/