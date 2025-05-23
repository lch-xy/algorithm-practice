package org.lch.泛型递归丨树的递归.Generate_Parentheses_0022;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {
    // 回溯 通过控制左括号的数量大于右括号的数量来做
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTracking(res, "", 0, 0, n);
        return res;
    }

    private void backTracking(List<String> res, String str, int open, int close, int n) {
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }

        if (open < n) {
            backTracking(res, str + "(", open + 1, close, n);
        }

        if (open > close) {
            backTracking(res, str + ")", open, close + 1, n);
        }
    }

}
