package org.lch.栈丨队列丨优先队列丨双端队列.Valid_Parentheses_0020;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: LCH
 * @Date: 2025/5/17 15:57
 */
public class Solution_1 {

    // 使用替换
    public boolean isValid(String s) {
        List<String> list = Arrays.asList("{}","()","[]");

        int startLen = s.length();
        int endLen = 0;
        while (startLen != endLen){
            startLen = s.length();
            for (String s1 : list) {
                s = s.replace(s1,"");
            }
            endLen = s.length();
        }
        if ("".equals(s)){
            return true;
        }
        return false;
    }

}
