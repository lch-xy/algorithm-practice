package org.lch.深度优先搜索丨广度优先搜索.Minimum_Genetic_Mutation_0433;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class Solution_1 {


    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)){
            return -1;
        }
        HashSet<String> visited = new HashSet<>();
        char[] vaildChar = new char[]{'A', 'C', 'G', 'T'};
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast(startGene);
        visited.add(startGene);
        int step = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String curGene = deque.pollFirst();
                if (curGene.equals(endGene)){
                    return step;
                }
                for (char c : vaildChar) {
                    char[] charArray = curGene.toCharArray();
                    for (int j = 0; j < curGene.length(); j++) {
                        char temp = charArray[j];
                        if (temp == c) continue;
                        charArray[j] = c;
                        String cur = new String(charArray);
                        if (bankSet.contains(cur) && !visited.contains(cur)){
                            deque.addLast(cur);
                            visited.add(cur);
                        }
                        charArray[j] = temp;
                    }
                }
            }
            step++;
        }
        return -1;
    }



}
