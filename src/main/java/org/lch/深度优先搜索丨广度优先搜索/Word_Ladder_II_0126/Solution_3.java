package org.lch.深度优先搜索丨广度优先搜索.Word_Ladder_II_0126;

import java.util.*;

public class Solution_3 {

    static List<List<String>> res = new ArrayList<>();
    static Map<String, List<String>> graph = new HashMap<>();


    // 使用双向BDF + DFS 还是无法ac
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return res;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        boolean found = false, reversed = false;

        while (!beginSet.isEmpty() && !endSet.isEmpty() && !found) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
                reversed = !reversed;
            }

            Set<String> nextLevel = new HashSet<>();
            wordSet.removeAll(beginSet);// 避免环路

            for (String word : beginSet) {
                char[] charArray = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char old = charArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (charArray[i] == c) continue;
                        charArray[i] = c;
                        String next = new String(charArray);

                        if (!wordSet.contains(next)) continue;

                        String from = reversed ? next : word;
                        String to = reversed ? word : next;

                        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);

                        if (endSet.contains(next)){
                            found = true;
                        }else {
                            nextLevel.add(next);
                        }
                    }
                    charArray[i] = old;
                }
            }
            beginSet = nextLevel;
        }

        if (found){
            dfs(beginWord, endWord, new ArrayList<>());
        }


        return res;
    }

    private static void dfs(String word, String endWord, ArrayList<String> path) {
        path.add(word);
        if (word.equals(endWord)) {
            res.add(new ArrayList<>(path));
        } else {
            for (String next : graph.getOrDefault(word, new ArrayList<>())) {
                if (graph.containsKey(word)){
                    dfs(next, endWord, path);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(findLadders(beginWord, endWord, wordList));
    }

}
