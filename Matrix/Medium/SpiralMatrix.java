import java.util.*;

// https://leetcode.com/problems/spiral-matrix/
class SpiralMatrix {
      public static List<Integer> spiralOrder(int[][] matrix) {
        // Approach 1 - Boundary Traversal
        // Time Complexity - O(m * n)    Space Complexity - O(1)
        List<Integer> answers = new ArrayList<>();
        
        int mnr = 0;
        int mxr = matrix.length - 1;
        int mnc = 0;
        int mxc = matrix[0].length - 1;
        
        while (mnr <= mxr && mnc <= mxc) {
            for (int i = mnc; i <= mxc; i++) {
                answers.add(matrix[mnr][i]);
            }
            mnr++;
            
            if (mnr > mxr || mnc > mxc) {
                break;
            }
            
            for (int i = mnr; i <= mxr; i++) {
                answers.add(matrix[i][mxc]);
            }
            mxc--;
            
            if (mnr > mxr || mnc > mxc) {
                break;
            }
            
            for (int i = mxc; i >= mnc; i--) {
                answers.add(matrix[mxr][i]);
            }
            mxr--;
            
            if (mnr > mxr || mnc > mxc) {
                break;
            }
            
            for (int i = mxr; i >= mnr; i--) {
                answers.add(matrix[i][mnc]);
            }
            mnc++;
            
            if (mnr > mxr || mnc > mxc) {
                break;
            }
        }
        return answers;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = scanner. nextInt();
            }
        }
        
        List<Integer> answers = spiralOrder(matrix);
        for (int ans : answers) {
            System.out.print(ans + " ");
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
1 2 3 6 9 8 7 4 5


Test Case - 2
Input:-
3 4
1 2 3 4
5 6 7 8
9 10 11 12
Output:-
1 2 3 4 8 12 11 10 9 5 6 7
*/
