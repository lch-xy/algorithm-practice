package org.lch.分治丨回溯.Letter_Combinations_Of_A_Phone_Number_0017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_1 {

    private static final String[] MAPPING = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return Collections.emptyList();
        }
        backTracking(new StringBuilder(),digits,0);
        return result;
    }

    private void backTracking(StringBuilder stringBuilder, String digits, int index) {
        if (stringBuilder.length() == digits.length()){
            result.add(stringBuilder.toString());
            return;
        }

        String curStr = MAPPING[digits.charAt(index) - '0'];
        for (char c : curStr.toCharArray()) {
            stringBuilder.append(c);
            backTracking(stringBuilder,digits,index+1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1 );
        }
    }


}
