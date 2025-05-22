package org.lch.哈希表丨映射丨集合.Vaild_Anagram_0242;

/**
 * @Author: LCH
 * @Date: 2025/5/22 23:00
 */
public class Solution_3 {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
