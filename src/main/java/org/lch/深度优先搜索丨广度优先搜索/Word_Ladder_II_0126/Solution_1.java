package org.lch.深度优先搜索丨广度优先搜索.Word_Ladder_II_0126;

import java.util.*;

public class Solution_1 {

    static List<List<String>> res = new ArrayList<>();
    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, Integer> distance = new HashMap<>();


    // Time Limit Exceeded
    // 先试用BFS构建邻接表和最短层级
    // 再使用DFS回溯所有路径
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return res;

        bfs(beginWord, endWord, wordSet);
        dfs(beginWord, endWord, new ArrayList<>());

        return res;
    }

    private static void dfs(String word, String endWord, ArrayList<String> path) {
        path.add(word);
        if (word.equals(endWord)) {
            res.add(new ArrayList<>(path));
        } else {
            for (String next : graph.getOrDefault(word, new ArrayList<>())) {
                // 核心剪枝逻辑
                // 必须按照层级顺序来访问，当前word是3 next是5 说明next不是word衔接而上的
                if (distance.get(next) == distance.get(word) + 1) {
                    dfs(next, endWord, path);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private static void bfs(String beginWord, String endWord, HashSet<String> wordSet) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(beginWord);
        distance.put(beginWord, 0);

        while (!deque.isEmpty()) {
            String word = deque.pollFirst();
            int curDist = distance.get(word);
            for (String nextWord : getNextWords(word, wordSet)) {
                graph.computeIfAbsent(word, k -> new ArrayList<>()).add(nextWord);
                if (!distance.containsKey(nextWord)) {
                    distance.put(nextWord, curDist + 1);
                    if (nextWord.equals(endWord)) continue;
                    deque.addLast(nextWord);
                }
            }
        }
    }

    // 获取所有只差一个字母的单词
    private static List<String> getNextWords(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                chars[i] = c;
                String next = new String(chars);
                if (dict.contains(next)) nextWords.add(next);
            }
            chars[i] = old;
        }
        return nextWords;
    }


    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log"});
        System.out.println(findLadders(beginWord, endWord, wordList));
    }

}
