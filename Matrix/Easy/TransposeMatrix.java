import java.util.Scanner;

// https://leetcode.com/problems/transpose-matrix/description/
public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        // Approach 1 - Brute Force
        // Time Complexity - O(n * m)     Space Complexity - O(n * m)
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] transpose = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
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
        
        int[][] transpose = transpose(matrix);
        for (int[] row : transpose) {
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
3
3
2 4 -1
-10 5 11
18 -7 6
Output:-
2 -10 18
4 5 -7
-1 11 6


Test Case - 2
Input:-
2
3
1 2 3
4 5 6
Output:-
1 4
2 5
3 6
*/