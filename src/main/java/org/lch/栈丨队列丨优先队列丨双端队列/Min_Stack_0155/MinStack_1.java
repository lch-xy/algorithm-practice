package org.lch.栈丨队列丨优先队列丨双端队列.Min_Stack_0155;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author: LCH
 * @Date: 2025/5/17 18:41
 */
public class MinStack_1 {
    Stack<Integer> mainStask = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack_1() {

    }

    public void push(int val) {
        mainStask.push(val);
        // 这里是>=，因为可能存在多少个值一样的数，
        // 在pop那如果mainStack和minStack一样大的时候就会都弹出
        if (minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }

    public void pop() {
        Integer p = mainStask.pop();
        if (Objects.equals(p, minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return mainStask.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
