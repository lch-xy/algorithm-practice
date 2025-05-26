package org.lch.泛型递归丨树的递归.Permutations_0046;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

    static List<List<Integer>> resultList = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
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
            res.add(nums[i]);
            used[i] = true;
            helper(res,nums,length,used);
            used[i] = false;
            res.remove(res.size()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
}
