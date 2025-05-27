package org.lch.贪心算法.Assign_Cookies_0455;

import java.util.Arrays;

public class Solution_1 {

    // 从后往前分
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gPoint = g.length - 1;
        int sPoint = s.length - 1;
        int count = 0;
        while (sPoint >= 0 && gPoint >= 0){
            if (s[sPoint] >= g[gPoint]){
                gPoint--;
                sPoint--;
                count++;
            }else {
                gPoint--;
            }
        }
        return count;
    }

}
