import java.util.*;

// https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        // Approach 1 - Sorting
        // Time Complexity - O(n * log(n))     Space Complexity - O(1)
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return sb.toString();
            }
            sb.append(first.charAt(i));
        }

        return sb.toString();

        // Approach 2 - Vertical Scanning
        // Time Complexity - O(n * m)     Space Complexity - O(1)
        String ans = "";

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || ch != strs[j].charAt(i)) {
                    return ans;
                }
            }

            ans += ch;
        }
        
        return ans;

        // Approach 3 - Horizontal Scanning
        // Time Complexity - O(n * m)     Space Complexity - O(1)
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.next();
        }

        System.out.print(longestCommonPrefix(strs));
    }
}

/*
Test Case - 1
Input:-
3
flower
flow
flight
Output:-
fl


Test Case - 2
Input:-
3
dog
racecar
car
Output:-



Test Case - 3
Input:-
2
ab
a
Output:-
a
*/