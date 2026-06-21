import java.util.*;

// https://leetcode.com/problems/valid-anagram/description/
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Approach 1 - Sorting
        // Time Complexity - O(n * log(n))     Space Complexity - O(n)
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        s = new String(a);
        t = new String(b);

        // return s.equals(t);

        // Approach 2 - HashMap
        // Time Complexity - O(n)     Space Complexity - O(n)
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int freq1 = map1.getOrDefault(ch, 0);
            int freq2 = map2.getOrDefault(ch, 0);

            if (freq1 != freq2) {
                return false;
            }
        }

        // Approach 3 - Frequency
        // Time Complexity - O(n)     Space Complexity - O(n)
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freq[ch - 'a']--;
        }

        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        System.out.print(isAnagram(s, t));
    }
}

/*
Test Case - 1
Input:-
anagram
nagaram
Output:-
true


Test Case - 2
Input:-
rat
car
Output:-
false
*/