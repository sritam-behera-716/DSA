import java.util.*;

// https://leetcode.com/problems/pascals-triangle/description/
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        // Approach 1 - Build Rows One By One
        // Time Complexity - O(n^2)    Space Complexity - O(n^2)
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                 if (j == 0 || j == i) {
                     list.add(1);
                 } else {
                     list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                 }
            }
            result.add(list);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int numRows = scanner.nextInt();
        
        List<List<Integer>> result = generate(numRows);
        for (List<Integer> list : result) {
            for (int item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}

/*
Test Case - 1
Input:-
5
Output:-
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1


Test Case - 2
Input:-
1
Output:-
1
*/
