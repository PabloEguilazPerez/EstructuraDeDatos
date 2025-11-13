package estdatos;

import java.util.*;

public class ListBag<E> extends AbstractCollection<E> {
    private final List<E> elements;

    public ListBag() {
        this.elements = new ArrayList<>();
    }

   
    public ListBag(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    @Override
    public boolean add(E e) {
        elements.add(e); 
        return true;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public boolean remove(Object o) {
        return elements.remove(o);
    }

    @Override
    public void clear() {
        elements.clear();
    }

    public int count(E e) {
        int cnt = 0;
        for (E elem : elements) {
            if (Objects.equals(elem, e)) cnt++;
        }
        return cnt;
    }


    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }
}