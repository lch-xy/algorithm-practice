package org.lch.深度优先搜索丨广度优先搜索.Word_Ladder_II_0126;

import java.util.*;

public class Solution_2 {


    // Time Limit Exceeded
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return res;

        Deque<List<String>> deque = new ArrayDeque<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        deque.addLast(path);

        Set<String> visited = new HashSet<>();
        int level = 1;
        int minLevel = Integer.MAX_VALUE;

        while (!deque.isEmpty()) {
            List<String> curPath = deque.pollFirst();
            // 说明进入了下一层 要将上一次访问过的字典移除，避免走回头路
            if (curPath.size() > level) {
                for (String word : visited) {
                    wordSet.remove(word);
                }
                visited.clear();
                level = curPath.size();

                if (level > minLevel) break;
            }

            String lastWord = curPath.get(curPath.size() - 1);
            char[] charArray = lastWord.toCharArray();
            for (int i = 0; i < lastWord.length(); i++) {
                char old = charArray[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == old) continue;

                    charArray[i] = c;
                    String nextWord = new String(charArray);

                    if (wordSet.contains(nextWord)) {
                        // 本层记录 然后下层移除
                        visited.add(nextWord);

                        List<String> newPath = new ArrayList<>(curPath);
                        newPath.add(nextWord);

                        if (endWord.equals(nextWord)) {
                            res.add(newPath);
                            minLevel = level;
                        } else {
                            deque.addLast(newPath);
                        }

                    }
                }
                charArray[i] = old;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(findLadders(beginWord, endWord, wordList));
    }

}
