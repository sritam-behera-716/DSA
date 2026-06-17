import java.util.Scanner;

// https://www.geeksforgeeks.org/problems/search-an-element-in-an-array-1587115621/1
public class LinearSearch {
    public static int search(int nums[], int target) {
        // Time Complexity - O(n)
        // Space Complexity - O(1)
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        System.out.print(search(nums, target));
    }
}

/*
Test Case - 1
Input:-
4
1 2 3 4
3
Output:-
2


Test Case - 2
Input:-
5
10 8 30 4 5
5
Output:-
4


Test Case - 3
Input:-
3
10 8 30
6
Output:-
-1
*/