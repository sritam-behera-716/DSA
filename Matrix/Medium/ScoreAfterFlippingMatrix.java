import java.util.Scanner;

// https://leetcode.com/problems/score-after-flipping-matrix/
public class ScoreAfterFlippingMatrix {
    public static int matrixScore(int[][] grid) {
        // Approach 1 - Greedy
        // Time Complexity - O(m * n)     Space Complexity - O(1)
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < c; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }
        
        for (int j = 1; j < c; j++) {
            int zero = 0, one = 0;
            for (int i = 0; i < r; i++) {
                if (grid[i][j] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            
            if (zero > one) {
                for (int i = 0; i < r; i++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }
         
        int score = 0;
        for (int i = 0; i < r; i++) {
            int binary = 1;
            for (int j = c - 1; j >= 0; j--) {
                score = score + binary * grid[i][j];
                binary = binary * 2;
            }
        }
        
        return score;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        
        System.out.print(matrixScore(grid));
    }
}

/*
Test Case - 1
Input:-
3 4
0 0 1 1
1 0 1 0
1 1 0 0
Output:-
39


Test Case - 2
Input:-
1 1
0
Output:-
1
*/
