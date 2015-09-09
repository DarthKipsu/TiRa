
package datastructures;

/**
 * Task: Implement basic queue.
 * @author kipsu
 */
public class Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public Queue<E> push(E value) {
        if (first == null) {
            first = new Node().setValue(value);
            last = first;
        } else {
             last.setNext(new Node().setValue(value));
             last = last.next();
        }
    return this;
    }

    public E pop() {
        if (first == null) {
            return null;
        }
        E value = first.value();
        first = first.next();
        return value;
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
    
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue();
        queue.push(1).push(2).push(3).push(4).push(5);
        
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}