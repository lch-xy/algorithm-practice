package org.lch.泛型递归丨树的递归.Permutations_II_0047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1 {

    static List<List<Integer>> resultList = new ArrayList<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(new ArrayList<>(),nums,nums.length,used);
        return resultList;
    }

    private static void helper(ArrayList<Integer> res, int[] nums, int length,boolean[] used) {
        if (res.size() == length){
            resultList.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            // 精髓是这个剪枝，如果上一个用过了，说明不是同一层，不需要剪枝
            // 如果上一个没用过，而且当前与上一个一样，说明上一个就跳过了，那这一个肯定也要跳过
            if (i > 0 && nums[i-1] == nums[i] && !used[i-1]){
                continue;
            }
            res.add(nums[i]);
            used[i] = true;
            helper(res,nums,length,used);
            used[i] = false;
            res.remove(res.size()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,1,1,1,3}));
    }
}
