package org.lch.分治丨回溯.Subsets_0078;

import java.util.ArrayList;
import java.util.List;

public class Solution_2 {


    // 逐步构造子集
    // 初始：res = [[]]
    // 加入 1 → [[], [1]]
    // 加入 2 → [[], [1], [2], [1,2]]
    // 加入 3 → [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = resultList.size();

            for (int j = 0; j < size; j++) {
                List<Integer> subset = new ArrayList<>(resultList.get(j));
                subset.add(nums[i]);
                resultList.add(subset);
            }
        }
        return resultList;
    }


}
