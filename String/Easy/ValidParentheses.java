import java.util.*;

// https://leetcode.com/problems/valid-anagram/description/
public class ValidParentheses {
    public static boolean isValid(String s) {
        // Approach 1 - Stack
        // Time Complexity - O(n)     Space Complexity - O(n)
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char peek = stack.peek();
                if (peek == '(' && ch == ')') {
                    stack.pop();
                } else if (peek == '{' && ch == '}') {
                    stack.pop();
                } else if (peek == '[' && ch == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.print(isValid(s));
    }
}

/*
Test Case - 1
Input:-
()
Output:-
true


Test Case - 2
Input:-
()[]{}
Output:-
true


Test Case - 3
Input:-
(]
Output:-
false


Test Case - 3
Input:-
([])
Output:-
true


Test Case - 3
Input:-
([)]
Output:-
false
*/