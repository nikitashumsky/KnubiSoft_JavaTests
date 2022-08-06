package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;
import com.knubisoft.base.queue.car.CarComparator;

import java.util.*;

public class QueueTasksImpl implements QueueTasks {

    @Override
    public Queue<Integer> reverseQueueUsingRecursion(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue;
        }
        int curr = queue.poll();
        reverseQueueUsingRecursion(queue);
        queue.add(curr);
        return queue;
    }

    @Override
    public Queue<Integer> reverseFirstKElementsOfQueue(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k > queue.size()) {
            return queue;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.poll());
        }
        return queue;
    }

    @Override
    public Queue<Integer> sortQueueOfInt(Queue<Integer> queue) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            temp.add(queue.poll());
        }
        Collections.sort(temp);
        for (int i = 0; i < temp.size(); i++) {
            queue.add(temp.get(i));
        }
        return queue;
    }

    @Override
    public boolean validParentheses(String parentheses) {
        Deque result = new LinkedList();
        for (int j = 0; j < parentheses.length(); j++) {
            char ch = parentheses.charAt(j);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    result.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!result.isEmpty()) {
                        char chx = result.pop().toString().charAt(0);
                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '('))
                            return false;
                    }
            }
        }
        return true;
    }

    @Override
    public PriorityQueue<Car> implementPriorityQueueThroughComparator(List<Car> cars) {
        PriorityQueue<Car> carsPriority = new PriorityQueue<>(cars.size(), new CarComparator());
        carsPriority.addAll(cars);
        return carsPriority;
    }

}
