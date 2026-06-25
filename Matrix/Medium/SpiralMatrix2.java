import java.util.Scanner;

// https://leetcode.com/problems/spiral-matrix-ii/
class SpiralMatrix2 {
    public static int[][] generateMatrix(int n) {
        // Approach 1 - Boundary Traversal
        // Time Complexity - O(m * n)    Space Complexity - O(1)
        int[][] matrix = new int[n][n];
        
        int mnr = 0;
        int mxr = n - 1;
        int mnc = 0;
        int mxc = n - 1;
        
        int count = 1;
        while (count <= n * n) {
            for (int i = mnc; i <= mxc && count <= n * n; i++) {
                matrix[mnr][i] = count++;
            }
            mnr++;
            
            for (int i = mnr; i <= mxr && count <= n * n; i++) {
                matrix[i][mxc] = count++;
            }
            mxc--;
            
            for (int i = mxc; i >= mnc && count <= n * n; i--) {
                matrix[mxr][i] = count++;
            }
            mxr--;
             
            for (int i = mxr; i >= mnr && count <= n * n; i--) {
                matrix[i][mnc] = count++;
            }
            mnc++;
        }
        
        return matrix;
    }
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        
        int[][] matrix = generateMatrix(n);
        for (int[] array : matrix) {
            for (int item : array) {
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
Output:-
1 2 3
8 9 4
7 6 5


Test Case - 2
Input:-
1
Output:-
1
*/
