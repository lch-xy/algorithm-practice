package org.lch.分治丨回溯.Subsets_0078;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

    List<List<Integer>> resultList = new ArrayList<>();

    // 每个元素“选”或“不选” → 二叉树结构 → 回溯法 or 位运算。
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(new ArrayList<>(),nums,0);
        return resultList;
    }

    private void backTracking(ArrayList<Integer> res, int[] nums, int start) {
        // 每一种可能都需要
        resultList.add(new ArrayList<>(res));

        for (int i = start; i < nums.length; i++) {
            res.add(nums[i]);
            backTracking(res,nums,i+1);
            res.remove(res.size() - 1);
        }
    }

}
