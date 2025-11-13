package estdatos;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListSet<E> extends AbstractSet<E> implements Set<E> {
    private final List<E> elements;

    public ListSet() {
        this.elements = new ArrayList<>();
    }

    public ListSet(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean add(E e) {
        if (!elements.contains(e)) {
            elements.add(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return elements.remove(o);
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }
}