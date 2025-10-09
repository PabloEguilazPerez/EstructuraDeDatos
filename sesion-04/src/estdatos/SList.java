package estdatos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SList<E> implements IList<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;

    public SList() {
        first = null;
        last = null;
        size = 0;
    }

    public SList(Iterable<E> collection) {
		this();
		for (E item : collection) {
			add(item);
		}
	} 
    
    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index < 0 || index > size");
        }

        Node<E> newNode = new Node<>(e, null);

        if (index == 0) {
            newNode.next = first;
            first = newNode;
            if (size == 0) last = newNode;
        } else {
            Node<E> prev = first;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
            if (newNode.next == null) last = newNode;
        }

        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index < 0 || index >= size");
        }

        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.item;
    }
    
    @Override
    public boolean remove(Object e) {
 
        Node<E> current = first;
        Node<E> previous = null;

        while (current != null) {
            if (current.item == null ? e == null : current.item.equals(e)) {
                if (previous == null) {
                    first = current.next;
                } else {
                    previous.next = current.next;
                }

                if (current == last) {
                    last = previous;
                }

                size--;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }
	
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String res = "[";
        Node<E> current = first;
        while (current != null) {
            res = res + " " + current.item.toString();
            current = current.next;
        }
        res = res + " ]";
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
    	
        if (!(obj instanceof SList<?> other)) return false;
        //https://docs.oracle.com/en/java/javase/17/language/pattern-matching-instanceof.html
        if (this.size != other.size) return false;

        Node<E> current1 = this.first;
        Node<?> current2 = other.first;

        while (current1 != null && current2 != null) {
            if (!current1.item.equals(current2.item)) return false;
            current1 = current1.next;
            current2 = current2.next;
        }

        return true;
    }
}