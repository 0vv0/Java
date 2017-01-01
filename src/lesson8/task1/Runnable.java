package lesson8.task1;

import java.util.Iterator;

/**
 * Created by Oleksii.Sergiienko on 12/28/2016.
 */
public class Runnable {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackOverDynamicArray<>();
        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Stack size=" + stack.size());

        //System.out.println(stack.peek());

        stack.push(5).push(6).push(222);

        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Stack size=" + stack.size());

        System.out.println("Show top: " + stack.peek());
        System.out.println("Get top: " + stack.pop());
        System.out.println("Show top: " + stack.peek());
        System.out.println("Get top: " + stack.pop());
        System.out.println("Show top: " + stack.peek());
        System.out.println("Get top: " + stack.pop());

        try {
            System.out.println("Show top: " + stack.peek());
            System.out.println("Get top: " + stack.pop());
        } catch (Exception e) {
            System.out.println(e);
        }

        stack.push(1).push(2).push(3);
        Iterator<Integer> iter = stack.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("*******************************");
        stack = new StackOverConnectedList<>();
        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Stack size=" + stack.size());

        //System.out.println(stack.peek());

        stack.push(5).push(6).push(222);

        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Stack size=" + stack.size());

        System.out.println("Show top: " + stack.peek());
        System.out.println("Get top: " + stack.pop());
        System.out.println("Get top: " + stack.pop());
        System.out.println("Get top: " + stack.pop());

        try {
            System.out.println("Show top: " + stack.peek());
            System.out.println("Get top: " + stack.pop());
        } catch (Exception e) {
            System.out.println(e);
        }

        stack.push(1).push(2).push(3);
        iter = stack.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("******** Stack over LinkedList **********");
        stack = new StackOverLinkedList<>();
        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Stack size=" + stack.size());

        //System.out.println(stack.peek());

        stack.push(5).push(6).push(222);

        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Stack size=" + stack.size());

        System.out.println("Show top: " + stack.peek());
        System.out.println("Get top: " + stack.pop());
        System.out.println("Get top: " + stack.pop());
        System.out.println("Get top: " + stack.pop());

        try {
            System.out.println("Show top: " + stack.peek());
            System.out.println("Get top: " + stack.pop());
        } catch (Exception e) {
            System.out.println(e);
        }

        stack.push(1).push(2).push(3);
        iter = stack.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
