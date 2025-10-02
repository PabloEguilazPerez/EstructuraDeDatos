package estdatos;

import java.util.AbstractCollection;
import java.util.Iterator;

public class BagNoMod<E> extends AbstractCollection<E> {
	
	private final E[] datos;
	private final int size;
	
	public BagNoMod(E... datos) {

		size = datos.length;
		
		this.datos = (E[]) new Object[size];
		
		for(int i = 0; i < size; i++) {
			this.datos[i] = datos[i];
		}
		
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
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
			
			E e = datos[index];
			index++;
			return e;
		}
		
	}

}