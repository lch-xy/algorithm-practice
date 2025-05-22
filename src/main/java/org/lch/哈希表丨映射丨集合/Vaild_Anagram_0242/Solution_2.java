package org.lch.哈希表丨映射丨集合.Vaild_Anagram_0242;

import java.util.Arrays;

/**
 * @Author: LCH
 * @Date: 2025/5/22 23:00
 */
public class Solution_2 {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(sArray);
        return Arrays.equals(tArray,sArray);
    }
}
