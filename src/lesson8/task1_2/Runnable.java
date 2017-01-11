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

    private static void getChecksForQueue(String title, Queue<Integer> queue){
        
        System.out.println("******** " + title + " **********");
        System.out.println("queue is empty? " + queue.isEmpty());
        System.out.println("queue size=" + queue.size());

        System.out.println("Added: 7, 8, 9");
        queue.push(5).push(6).push(7);

        System.out.println("queue is empty? " + queue.isEmpty());
        System.out.println("queue size=" + queue.size());

        System.out.println("Show top: " + queue.peek());
        System.out.println("Get top: " + queue.pop());
        System.out.println("Get top: " + queue.pop());
        System.out.println("Get top: " + queue.pop());

        try {
            System.out.println("Show top: " + queue.peek());
            System.out.println("Get top: " + queue.pop());
        } catch (NoSuchElementException e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("Added: 1, 2, 3");
        queue.push(1).push(2).push(3);
        for (Object aQueue : queue) {
            System.out.println(aQueue);
        }
    }
    
    private static void getChecksForStack(String title, Stack<Integer> stack){

        System.out.println("******** " + title + " **********");
        System.out.println("stack is empty? " + stack.isEmpty());
        System.out.println("stack size=" + stack.size());

        System.out.println("Added: 7, 8, 9");
        stack.push(7).push(8).push(9);

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
        stack.push(1).push(2).push(3);
        for (Object aStack : stack) {
            System.out.println(aStack);
        }
    }
}
