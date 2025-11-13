package estdatos;

import java.util.*;

public class SortedListSet<E> extends AbstractSet<E> {
    private final List<E> elements;
    private final Comparator<? super E> comparator;

    public SortedListSet() {
        this(null);
    }

    public SortedListSet(Comparator<? super E> comp) {
        this.elements = new ArrayList<>();
        this.comparator = comp;
    }

    @Override
    public boolean add(E e) {
        int idx = Collections.binarySearch(elements, e, comparator);
        if (idx < 0) {
            elements.add(-idx - 1, e);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return Collections.binarySearch(elements, (E) o, comparator) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public int size() {
        return elements.size();
    }
}