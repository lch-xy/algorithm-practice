package org.lch.哈希表丨映射丨集合.Group_Anagrams_0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LCH
 * @Date: 2025/5/22 22:41
 */
public class Solution_1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            res.computeIfAbsent(key,k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
