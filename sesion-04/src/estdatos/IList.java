package estdatos;

import java.util.Collection;

public interface IList<E> extends Iterable<E> {

    int size();

    void add(int index, E e);

    E get(int index);

    boolean remove(Object e);

    default boolean add(E e) {
        add(size(), e);
        return true;
    }

    default boolean contains(Object e) {
        for (E item : this) {
            if (item == null ? e == null : item.equals(e)) {
                return true;
            }
        }
        return false;
    }

    default boolean addAll(Collection<E> c) {
        boolean changed = false;
        for (E item : c) {
            if (add(item)) {
                changed = true;
            }
        }
        return changed;
    }

    default boolean containsAll(IList<E> l) {
        for (E item : l) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }
}
