package lesson8.task1_2;

import java.util.NoSuchElementException;

/**
 * Created by Oleksii.Sergiienko on 12/28/2016.
 */
class Runnable {
    public static void main(String[] args) {
        getChecksForStack("******** stack over Dynamic Array **********", new StackOverDynamicArray<>() );
        getChecksForStack("******** stack over Connected List **********", new StackOverConnectedList<>() );
        getChecksForStack("******** stack over Linked List **********", new StackOverLinkedList<>() );

        getChecksForQueue("******** queue over Dynamic Array **********", new QueueOverDynamicArray<>() );
        getChecksForQueue("******** queue over Connected List **********", new QueueOverConnectedList<>() );
        getChecksForQueue("******** queue over LinkedList **********", new QueueOverLinkedList<>() );

    }

    private static void getChecksForQueue(String title, Queue<Integer> queue) {
        
        System.out.println("******** " + title + " **********");
        System.out.println("queue is empty? " + queue.isEmpty());
        System.out.println("queue size=" + queue.size());

        System.out.println("Added: 5, 6, 7");
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);

        System.out.println("queue is empty? " + queue.isEmpty());
        System.out.println("queue size=" + queue.size());

        System.out.println("Show top: " + queue.peek());
        System.out.println("Get top: " + queue.poll());
        System.out.println("Get top: " + queue.poll());
        System.out.println("Get top: " + queue.poll());

        try {
            System.out.println("Show top: " + queue.peek());
            System.out.println("Get top: " + queue.poll());
        } catch (NoSuchElementException e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("Added: 1, 2, 3");
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Object aQueue : queue) {
            System.out.println(aQueue);
        }
    }

    private static void getChecksForStack(String title, Stack<Integer> stack) {

        System.out.println("******** " + title + " **********");
        System.out.println("stack is empty? " + stack.isEmpty());
        System.out.println("stack size=" + stack.size());

        System.out.println("Added: 7, 8, 9");
        stack.push(7);
        stack.push(8);
        stack.push(9);

        System.out.println("stack is empty? " + stack.isEmpty());
        System.out.println("stack size=" + stack.size());

        System.out.println("Show top: " + stack.peek());
        System.out.println("Get top: " + stack.pop());
        System.out.println("Get top: " + stack.pop());
        System.out.println("Get top: " + stack.pop());

        try {
            System.out.println("Show top: " + stack.peek());
            System.out.println("Get top: " + stack.pop());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("Added: 1, 2, 3");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (Object aStack : stack) {
            System.out.println(aStack);
        }
    }
}
