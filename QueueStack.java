package com.company;
/* Description: push and pop methods in queue stack
    - push - add items to the end of the array and returns new length
    - pop - removes and returns the last element in an array
 */
public class QueueStack {
    private int size;
    private int[] elements;
    private int head;

    public QueueStack(int capacity) {
        size = capacity;
        elements = new int[size];
    }

    public int push(int item) {
        if (head == elements.length) {
            throw new StackOverflowError();
        }
        elements[head] = item;
        head++;
        return item;
    }

    public int pop() {
        if (head == 0) {
            throw new IllegalArgumentException();
        }

        head--;
        return elements[head];
    }

    public int peek() {
        if (head == 0) {
            throw new IllegalArgumentException();
        }
        return elements[head - 1];
    }

    public boolean isEmpty() {
        return (head == 0);
    }

    public String toString() {
        String r = "[" + elements[0];

        if (head < 0) {
            return "[]";
        }
        else {
            for (int i = 1; i < elements.length; i++) {
                r += " " + elements[i];
            }
        }
        return r + "]";
    }

    public static void main(String[] args) {
        QueueStack queueIn = new QueueStack(5);
        QueueStack queueOut = new QueueStack(queueIn.size);

        queueIn.push(1);
        queueIn.push(2);
        queueIn.push(3);
        queueIn.push(4);
        queueIn.push(5);
        System.out.println("Before: " + queueIn);

        while (queueIn.isEmpty() == false) {
            queueOut.push(queueIn.peek());
            queueIn.pop();
        }

        while (queueOut.isEmpty() == false) {
            int x = queueOut.peek();
            queueOut.pop();
            queueIn.push(x);
        }
        System.out.println("After: " + queueOut);
    }
}
