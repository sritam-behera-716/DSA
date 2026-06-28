import java.util.Scanner;

// https://leetcode.com/problems/set-matrix-zeroes/
class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        // Approach 1 - Brute Force
        // Time Complexity - O(m * n)     Space Complexity - O(m * n)
        int[][] copy = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (copy[i][j] == 0) {
                    for (int k = 0; k < r; k++) {
                        matrix[k][j] = 0;
                    }
                    for (int k = 0; k < c; k++) {
                        matrix[i][k] = 0;
                    }
                }
            }
        }
        
        // Approach 2 - Row + Column Array
        // Time Complexity - O(m * n)     Space Complexity - O(m + n)
        boolean[] row = new boolean[r];
        boolean[] col = new boolean[c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        
        for (int i = 0; i < r; i++) {
            if (row[i]) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int j = 0; j < c; j++) {
            if (col[j]) {
                for (int i = 0; i < r; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Approach 3 - Row + Column Marker
        // Time Complexity - O(m * n)     Space Complexity - O(1)
        boolean row = false, col = false;
        
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                row = true;
                break;
            }
        }
        
        for (int j = 0; j < c; j++) {
            if (matrix[0][j] == 0) {
                col = true;
                break;
            }
        }
        
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                matrix[i][0] = matrix [0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < r; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int j = 1; j < c; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < r; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (row) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if (col) {
            for (int j = 0; j < c; j++) {
                matrix[0][j] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        setZeroes(matrix);
        for (int[] array : matrix) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

/*
Test Case - 1
Input:-
3 3
1 1 1
1 0 1
1 1 1
Output:-
1 0 1
0 0 0
1 0 1


Test Case - 2
Input:-
3 4
0 1 2 0
3 4 5 2
1 3 1 5
Output:-
0 0 0 0
0 4 5 0
0 3 1 0
*/
