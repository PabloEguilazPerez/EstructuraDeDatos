package estdatos;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class BagMod<E> extends AbstractCollection<E> {

    protected final E[] datos;
    protected int size;

    public BagMod(int capacity) {
        this.datos = (E[]) new Object[capacity];
        this.size = 0;
    }

    public BagMod(Collection<E> c) {
        this(c.size());
        addAll(c);
    }

    @Override
    public boolean add(E elemento) {
        if (size >= datos.length) {
            return false;
        }
        datos[size] = elemento;
        size++;
        return true;
    }
    

	@Override
	public boolean remove(Object o) {
	    for (int i = 0; i < size; i++) {
	        if (datos[i].equals(o)) {
				for (int j = i; j < size - 1; j++) {
				    datos[j] = datos[j + 1];
				}
				datos[size - 1] = null;
	            size--;
	            return true;
	        }
	    }
	    return false;
	}

	
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return this.size;
    }

    private class MyIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return datos[index++];
        }
    }

}