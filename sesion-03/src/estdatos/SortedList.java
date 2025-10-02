package estdatos;

import java.util.Comparator;

public class SortedList<E> extends MyArrayList<E> {
	
	private Comparator<E> comparator;

	public SortedList(Comparator<E> comparator) {
		this.comparator = comparator;
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
