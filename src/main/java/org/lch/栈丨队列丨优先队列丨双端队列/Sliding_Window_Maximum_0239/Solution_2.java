package org.lch.栈丨队列丨优先队列丨双端队列.Sliding_Window_Maximum_0239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_2 {

    // 双端队列
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // 如果滑动窗口已经过了 移除队头元素 将元素控制的k个内
            if (!deque.isEmpty() && deque.peekFirst() + k - 1 < i) {
                deque.pollFirst();
            }

            // 如果队尾值比当前的小，那就出来，因为它没啥用了
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 队头一定是最大元素，因为比它小的都已经出队了，
            deque.offerLast(i);

            // k是长度，要-1才是索引
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}
