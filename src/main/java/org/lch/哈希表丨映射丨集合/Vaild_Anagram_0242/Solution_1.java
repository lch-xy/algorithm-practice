package org.lch.哈希表丨映射丨集合.Vaild_Anagram_0242;

import java.util.HashMap;

/**
 * @Author: LCH
 * @Date: 2025/5/21 21:39
 */
public class Solution_1 {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        for (char c : sCharArray) {
            if (map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else {
                map.put(c,1);
            }
        }
        char[] tCharArray = t.toCharArray();
        for (char c : tCharArray) {
            if (map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if (map.get(c) == 0){
                    map.remove(c);
                }
            }else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("ab","a"));
    }

}
