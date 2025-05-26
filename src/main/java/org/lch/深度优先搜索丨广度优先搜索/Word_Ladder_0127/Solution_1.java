package org.lch.深度优先搜索丨广度优先搜索.Word_Ladder_0127;

import java.util.*;

public class Solution_1 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        if (!wordSet.contains(endWord)) return 0;
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(beginWord);

        int step = 1;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String cur = deque.pollFirst();
                if (Objects.equals(cur, endWord)){
                    return step;
                }
                char[] charArray = cur.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char temp = charArray[j];
                        charArray[j] = c;
                        String str = new String(charArray);
                        if (wordSet.contains(str) && !visited.contains(str)){
                            deque.addLast(str);
                            visited.add(str);
                        }
                        charArray[j] = temp;
                    }
                }
            }
            step++;
        }
        return 0;
    }


}
