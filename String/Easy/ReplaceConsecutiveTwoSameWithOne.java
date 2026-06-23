import java.util.Scanner;

// https://www.geeksforgeeks.org/problems/consecutive-elements2306/1
public class ReplaceConsecutiveTwoSameWithOne {
    public static String removeDuplicates(String s) {
        // Approach 1 - Linear Traversal
        // Time Complexity - O(n)     Space Complexity - O(1)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(removeDuplicates(s));
    }
}

/*
Test Case - 1
Input:-
aabb
Output:-
ab


Test Case - 2
Input:-
aabaa
Output:-
aba


Test Case - 3
Input:-
aaaa
Output:-
a
*/