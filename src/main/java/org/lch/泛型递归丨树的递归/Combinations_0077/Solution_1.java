package org.lch.泛型递归丨树的递归.Combinations_0077;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

    /**
     * 采用回溯法 不要混淆 start 和 k 的意义
     */

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(new ArrayList<>(), n, k, 1);
        return resultList;
    }

    private void helper(List<Integer> res, int n, int k, int start) {
        if (res.size() == k) {
            resultList.add(new ArrayList<>(res));
            return;
        }
        for (int i = start; i <= n; i++) {
            res.add(i);
            helper(res, n, k, i + 1);
            res.remove(res.size() - 1);
        }
    }

}
