import java.util.Scanner;

// https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Approach 1 - Linear Search
        // Time Complexity - O(m * n))     Space Complexity - O(1)
        for (int[] array : matrix) {
            for (int item : array) {
                if (item == target) {
                    return true;
                }
            }
        }
        
        // Approach 2 - Binary Search
        // Time Complexity - O(log(m * n))     Space Complexity - O(1)
        int r = matrix.length;
        int c = matrix[0].length;
        int i = 0, j = c - 1;
        while (i < r && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        
        return false;
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
        int target = scanner.nextInt();
        
        System.out.print(searchMatrix(matrix, target));
    }
}

/*
Test Case - 1
Input:-
3 4
1 3 5 7
10 11 16 20
23 30 34 60
3
Output:-
true


Test Case - 2
Input:-
3 4
1 3 5 7
10 11 16 20
23 30 34 60
13
Output:-
false
*/
