package org.lch.动态规划.Minimum_Window_Substring_0076;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 {

    // 使用hashMap + sliding Windows
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windows = new HashMap<>();

        int left = 0, right = 0;
        int valid = 0;
        // 记录其实位置和字符串长度
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 条件满足
            while (valid == need.size()) {
                // 更新字符串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
//        System.out.println(minWindow("a", "a"));
    }

}
