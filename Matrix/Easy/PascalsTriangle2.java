import java.util.*;

// https://leetcode.com/problems/pascals-triangle-ii/
public class PascalsTriangle2 {
    public static List<Integer> getRow(int rowIndex) {
        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)    Space Complexity - O(n^2)
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
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

        return result.get(rowIndex);
        
        // Approach 2 - Build Required Row
        // Time Complexity - O(n^2)    Space Complexity - O(n)
        List<Integer> list = new ArrayList<>();
        list.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            list.add(1);
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int rowIndex = scanner.nextInt();
        
        List<Integer> list = getRow(rowIndex);
        for (int item : list) {
            System.out.print(item + " ");
        }
    }
}

/*
Test Case - 1
Input:-
3
Output:-
1 3 3 1


Test Case - 2
Input:-
0
Output:-
1


Test Case - 3
Input:-
1
Output:-
1 1
*/
