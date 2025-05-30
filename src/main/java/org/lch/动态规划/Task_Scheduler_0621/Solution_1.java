package org.lch.动态规划.Task_Scheduler_0621;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_1 {

    // 先统计每种任务出现的次数
    // 使用大顶堆 入栈每个任务出现的次数
    // 一轮一轮来 入堆出堆
    public static int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        // 反一下
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : taskCounts) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        int time = 0;
        while (!maxHeap.isEmpty()) {
            int curTime = 0;
            List<Integer> temp = new ArrayList<>();
            int size = n + 1;
            for (int i = 0; i < size; i++) {
                if (!maxHeap.isEmpty()) {
                    int cnt = maxHeap.poll();
                    if (cnt - 1 > 0) {
                        temp.add(cnt - 1);
                    }
                    curTime++;
                }
            }

            // task 是一轮一轮来的
            for (int remaining : temp) {
                maxHeap.offer(remaining);
            }

            time += maxHeap.isEmpty() ? curTime : size;
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'},3));
    }

}
