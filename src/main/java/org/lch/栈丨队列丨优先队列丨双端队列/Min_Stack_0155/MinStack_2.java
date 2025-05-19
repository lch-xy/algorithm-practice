package org.lch.栈丨队列丨优先队列丨双端队列.Min_Stack_0155;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author: LCH
 * @Date: 2025/5/17 18:41
 */
public class MinStack_2 {
    Stack<Integer> mainStask = new Stack<>();

    int minValue = Integer.MAX_VALUE;

    public MinStack_2() {

    }

    public void push(int val) {
        if (val <= minValue){
            mainStask.push(minValue);
            minValue = val;
        }
        mainStask.push(val);

    }

    public void pop() {
        Integer p = mainStask.pop();
        if (p == minValue){
            minValue = mainStask.pop();
        }
    }

    public int top() {
        return mainStask.peek();
    }

    public int getMin() {
        return minValue;
    }
}
