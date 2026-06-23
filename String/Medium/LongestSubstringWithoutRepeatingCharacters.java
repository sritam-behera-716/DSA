import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;

        // Approach 1 - Brute Force
        // Time Complexity - O(n^2)     Space Complexity - O(n)
        for (int i = 0; i < n; i++) {
            int count = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (map.containsKey(ch)) {
                    map.clear();
                    break;
                }
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                count++;
            }
            max = Math.max(max, count);
        }

        // Approach 2 - Sliding Window
        // Time Complexity - O(n)     Space Complexity - O(n)
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < n) {
            while (!set.add(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(lengthOfLongestSubstring(s));
    }
}

/*
Test Case - 1
Input:-
abcabcbb
Output:-
3


Test Case - 2
Input:-
bbbbb
Output:-
1


Test Case - 3
Input:-
pwwkew
Output:-
3
*/