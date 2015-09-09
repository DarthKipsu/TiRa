
package datastructures;

/**
 * Task: implement a single linked list. Then, delete a node by it's value.
 * @author kipsu
 */
public class LinkedList<E> {
    private E value;
    private LinkedList<E> next;

    public E value() {
        return value;
    }

    public LinkedList<E> next() {
        return next;
    }

    public LinkedList<E> setValue(E value) {
        this.value = value;
        return this;
    }
    
    public LinkedList<E> append(E value) {
        if (this.value == null) {
            this.value = value;
        } else if (next == null) {
            next = new LinkedList<E>().setValue(value);
        } else {
            next.append(value);
        }
        return this;
    }
    
    public LinkedList<E> deleteValue(E value) {
        if (this.value == value) {
            if (next == null) {
                this.value = null;
            } else {
                this.value = next.value;
                this.next = next.next;
            }
        } else {
            next.deleteValue(value);
        }
        return this;
    }

    @Override
    public String toString() {
        return value + (next != null ? " > " + next.toString() : "");
    }
    
    // test
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList()
                .append(1)
                .append(2)
                .append(3)
                .append(4)
                .append(5);
        
        System.out.println(list);
        list.deleteValue(3);
        System.out.println(list);
        list.deleteValue(1);
        System.out.println(list);
    }
}
