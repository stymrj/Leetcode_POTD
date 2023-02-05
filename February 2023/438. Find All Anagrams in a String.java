/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) return rst;
        
        int n = s.length(), m = p.length();

        // prep the count and window
        int[] window = new int[26], countP = new int[26];
        for (int i = 0; i < m; i++) {
            window[s.charAt(i) - 'a']++;
            countP[p.charAt(i) - 'a']++;
        }
        
        // compare at index = 0
        if (compare(window, countP)) rst.add(0);
        
        for (int i = m; i < n; i++) {
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - m) - 'a']--;
            if (compare(window, countP)) rst.add(i - m + 1);
        }
        
        return rst;
    }
    
    private boolean compare(int[] window, int[] countP) {
        for (int i = 0; i < 26; i++) {
            if (window[i] != countP[i]) return false;
        }
        return true;
    }
}
