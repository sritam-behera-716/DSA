import java.util.Scanner;

// https://leetcode.com/problems/reverse-vowels-of-a-string/description/
public class ReverseVowelsOfAString {
    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }

    public static String reverseVowels(String s) {
        // Approach 1 - Two Pointer
        // Time Complexity - O(n)     Space Complexity - O(1)
        char[] array =s.toCharArray();

        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!isVowel(leftChar)) {
                left++;
            } else if (!isVowel(rightChar)) {
                right--;
            } else {
                array[left] = rightChar;
                array[right] = leftChar;
                left++;
                right--;
            }
        }

        return new String(array);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.print(reverseVowels(s));
        scanner.close();
    }
}

/*
Test Case - 1
Input:-
IceCreAm
Output:-
AceCreIm


Test Case - 2
Input:-
leetcode
Output:-
leotcede
*/