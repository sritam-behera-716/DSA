import java.util.Scanner;

// https://leetcode.com/problems/reverse-words-in-a-string/description/
public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        String[] strs = s.split("\\s+");
        String ans = "";

        // Approach 1 - Brute Force
        // Time Complexity - O(n)     Space Complexity - O(n)
        for (int i = strs.length - 1; i >= 0; i--) {
            ans += strs[i];
            if (i != 0) {
                ans += " ";
            }
        }

        // Approach 2 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(n)
        int start = 0, end = strs.length - 1;
        while (start < end) {
            String temp = strs[start];
            strs[start] = strs[end];
            strs[end] = temp;
            start++;
            end--;
        }

        for (String str : strs) {
            ans += str;
            if (ans.length() > 0) {
                ans += " ";
            }
        }

        return ans.trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(reverseWords(s));
        scanner.close();
    }
}

/*
Test Case - 1
Input:-
the sky is blue
Output:-
blue is sky the


Test Case - 2
Input:-
  hello world  
Output:-
world hello


Test Case - 3
Input:-
a good   example 
Output:-
example good a
*/