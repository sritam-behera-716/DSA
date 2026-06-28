import java.util.*;

// https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1
public class TripletsWithSmallerSum {
    public static int countTriplets(int[] arr, int sum) {
        int n = arr.length;
        int count = 0;
        
        // Approach 1 - Brute Force
        // Time Complexity - O(n^3)     Space Complexity - O(1)
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] < sum) {
                        count++;
                    }
                }
            }
        }
        
        // Approach 2 - Three Pointer
        // Time Complexity - O(n^2)     Space Complexity - O(1)
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] < sum) {
                    count = count + (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int sum = scanner.nextInt();
        
        System.out.println(countTriplets(arr, sum));
    }
}

/*
Test Case - 1
Input:-
4
-2 0 1 3
2
Output:-
2


Test Case - 2
Input:-
5
5 1 3 4 7
12
Output:-
4
*/
