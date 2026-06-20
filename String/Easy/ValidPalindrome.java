import java.util.Scanner;

// https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        // Approach 1 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(1)
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetter(leftChar) && !Character.isDigit(leftChar)) {
                left++;
                continue;
            }

            if (!Character.isLetter(rightChar) && !Character.isDigit(leftChar)) {
                right--;
                continue;
            }

            if (Character.compare(leftChar, rightChar) != 0) {
                return false;
            }

            left++;
            right--;

        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(isPalindrome(s));
    }
}

/*
Test Case - 1
Input:-
A man, a plan, a canal: Panama
Output:-
false


Test Case - 2
Input:-
race a car
Output:-
false


Test Case - 3
Input:-
 
Output:-
true


Test Case - 4
Input:-
0P
Output:-
false
*/