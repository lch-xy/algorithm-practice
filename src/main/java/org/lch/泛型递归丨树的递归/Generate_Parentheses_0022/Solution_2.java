package org.lch.泛型递归丨树的递归.Generate_Parentheses_0022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_2 {

    /**
     * dp[i]：构造 i 对括号的所有合法组合
     * 这个结构总共用了一对新的括号 ()，所以里面的内容加外面的内容应该正好还剩 i - 1 对括号。
     * 我们把这 i - 1 对括号分为两部分：
     *          j 对括号放在括号里面，也就是 inside
     *          i - 1 - j 对括号放在括号外面，也就是 outside
     *  dp[i] ⊇ "(" + dp[j] 的一个元素 + ")" + dp[i - 1 - j] 的一个元素
     */
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(Collections.singletonList("")); // init dp[0]

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String inside : dp.get(j)) {
                    for (String outside : dp.get(i - j - 1)) {
                        cur.add("(" + inside + ")" + outside);
                    }
                }
            }
            dp.add(cur);
        }

        return dp.get(n);
    }

}
