package org.lch.深度优先搜索丨广度优先搜索.Word_Ladder_0127;

import java.util.*;

public class Solution_2 {

    // 双向bfs
    // 使用两个 Set，一个从 beginWord 开始扩散，另一个从 endWord 开始。
    // 每次从较小的集合扩展（减少分支数），如果两个集合有交集，说明找到了最短路径。
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()){
            // 每次从小的集合开始扩散
            if (beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();

            for (String word : beginSet) {
                char[] charArray = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char old = charArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        charArray[i] = c;
                        String str = new String(charArray);
                        if (endSet.contains(str)){
                            return step + 1;
                        }

                        // 筛选并记录下一层可以扩展的合法单词
                        if (wordSet.contains(str) && !visited.contains(str)){
                            visited.add(str);
                            nextLevel.add(str);
                        }
                    }
                    charArray[i] = old;
                }
            }
            beginSet = nextLevel;
            step++;
        }
        return 0;
    }


}
