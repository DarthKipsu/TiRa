
package datastructures;

/**
 * Task: Implement a basic stack.
 * @author kipsu
 */
public class Stack<E> {
    private Node<E> top;

    public Stack<E> push(E value) {
        top = new Node().setValue(value).setNext(top);
        return this;
    }

    public E pop() {
        if (top != null) {
            E topValue = top.value();
            top = top.next();
            return topValue;
        }
        return null;
    }
    
    private class Node<E> {
        private E value;
        private Node<E> next;

        public Node<E> setValue(E value) {
            this.value = value;
            return this;
        }
        public Node<E> setNext(Node<E> next) {
            this.next = next;
            return this;
        }
        public E value() {
             return value;
        }
        public Node<E> next() {
            return next;
        }
    }
    
    // Test the method.
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
