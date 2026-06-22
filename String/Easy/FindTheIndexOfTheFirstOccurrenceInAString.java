import java.util.Scanner;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=problem-list-v2&envId=string
public class FindTheIndexOfTheFirstOccurrenceInAString{
    public static int strStr(String haystack, String needle) {
        // Approach 1 - Built-in function
        // Time Complexity - O(n * m)     Space Complexity - O(1)
        return haystack.indexOf(needle);

        // Approach 2 - Sliding Window
        // Time Complexity - O(n * m)     Space Complexity - O(1)
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String haystack = scanner.next();
        String needle = scanner.next();

        System.out.println(strStr(haystack, needle));
    }
}

/*
Test Case - 1
Input:-
sadbutsad
sad
Output:-
0


Test Case - 2
Input:-
leetcode
leeto
Output:-
-1
*/