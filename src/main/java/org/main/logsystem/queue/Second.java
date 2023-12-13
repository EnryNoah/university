package org.main.logsystem.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Second {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    public Second() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    public int pop() {
        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }

        int poppedElement = queue1.remove();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedElement;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        Second myStack = new Second();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
