package org.lch.栈丨队列丨优先队列丨双端队列.Valid_Parentheses_0020;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

/**
 * @Author: LCH
 * @Date: 2025/5/17 15:57
 */
public class Solution_2 {

    // 使用stack
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (Character c : charArray) {
            if (map.containsKey(c)) {
                // 如果栈为空，或者栈顶元素不是对应的左括号，直接返回 false
                if (stack.empty() || map.get(c) != stack.pop()){
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
//        System.out.println(isValid("({[)"));
        System.out.println(isValid("({})"));
    }
}
