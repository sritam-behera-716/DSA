import java.util.Scanner;

// https://leetcode.com/problems/reverse-string/
public class ReverseString {
    public static void reverseString(char[] s) {
        // Approach 1 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(1)
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] s = str.toCharArray();

        reverseString(s);
        for (char ch : s) {
            System.out.print(ch);
        }
    }
}

/*
Test Case - 1
Input:-
hello
Output:-
0lleh


Test Case - 2
Input:-
Hannah
Output:-
hannaH
*/