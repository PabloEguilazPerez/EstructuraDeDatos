package estdatos;

import java.util.Collection;
import java.util.Comparator;

public class SortedList<E> extends MyArrayList<E> {
	
	private Comparator<E> comparator;
	
	public SortedList(int initialCapacity) {
		super(initialCapacity);
		this.comparator = null;
	}
	
	public SortedList() {
		this(10);
	}
	
	public SortedList(Collection<E> c) {
		super(c);
	}
	
	public SortedList(Comparator<E> comparator) {
		this();
		this.comparator = comparator;
	}
	
	@Override
    public boolean add(E e) {
        int index = findInsertIndex(e);
        super.add(index, e);
        return true;
    }
	
	@Override
    public void add(int index, E element) {
        add(element);
    }
	
	private int compare(E a, E b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        if (a instanceof Comparable) {
            return ((Comparable<E>) a).compareTo(b);
        }
        throw new IllegalStateException("No se puede ordenar");
    }

    private int findInsertIndex(E e) {
        int low = 0;
        int high = size();
        while (low < high) {
            int mid = (low + high) / 2;
            E midVal = get(mid);
            if (compare(e, midVal) > 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
