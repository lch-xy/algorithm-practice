package org.lch.栈丨队列丨优先队列丨双端队列.Design_Circular_Deque_0641;

public class MyCircularDeque {
    // 因为容量大小是固定的 所以可以使用数组来做
    private int[] data;
    // 指向头元素
    private int front;
    // 指向下一个可以插入的位置
    private int rear;
    private int capacity;

    public MyCircularDeque(int k) {
        // 我们采用 rear + 1 == front 代表满，rear == front 代表空。所以得多一个空间
        capacity = k + 1;
        data = new int[capacity];
        front = 0;
        rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }
        // 避免负数
        front = (front - 1 + capacity) % capacity;
        data[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        data[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        // 避免负数
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        // 为什么这里是front？
        // front 始终指向的是 当前的第一个有效元素的位置
        return data[front];
    }

    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        // 为什么是(rear - 1 + capacity) % capacity？
        // rear 始终指向的是 下一个要插入的位置
        return data[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
