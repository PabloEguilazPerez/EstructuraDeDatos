package estdatos;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> extends AbstractList<E> implements List<E> {
	
	private E[] data;
	private int size;
	
	public MyArrayList() {
		data = (E[]) new Object[10];
	}
	
	public MyArrayList(int initialCapacity) {
		data = (E[]) new Object[initialCapacity];
	}
	
	public MyArrayList(Collection<? extends E> c) {
		this(c.size());
		addAll(c);
	}
	
	@Override
	public boolean add(E e) {
		
		if (size >= data.length) {
			this.aumentarEspacio(1);
		}
		
		data[size] = e;
		
		size++;
		
		return true;
		
	}
	
	public void add(int index, E e) {
		
		if (size >= data.length) {
			throw new IndexOutOfBoundsException("No hay espacio");
		}
		
		System.arraycopy(data, index, data, index + 1, size - index);
		
		data[index] = e;
		
		size++;
		
	}
	
	public int capacity() {
		return data.length;
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E get(int index) {
		
		return data[index];
		
	}
	
	@Override
	public E set(int index, E element) {
		
		if (index >= size) {
			throw new IndexOutOfBoundsException("Fuera de indice");
		}
		
		E anterior = this.get(index);
		data[index] = element;
		return anterior;
		
	}
	
	@Override
	public E remove(int index) {
		
		E anterior = this.get(index);
		
		data[index] = null;
		
		System.arraycopy(data, index + 1 , data, index, size - index); 
		
		size--;
		
		return anterior;
		
	}
	
	@Override
	public String toString() {
		
		if (size == 0) {
			return "[]";
		}
		
		String s = "[" + data[0];
		
		for(int i = 1; i < size - 1; i++) {
			s = s + ", " + data[i];
		}
		
		s = s + ", " + data[size -1] + "]";
		
		return s;
	}
	
	public void aumentarEspacio(int elmentosAdd) {
		
		E[] datosAnt = data;
		
		data = (E[]) new Object[data.length * 2];
		
		System.arraycopy(datosAnt, 0 , data, 0, datosAnt.length); 
		
	}
	
	@Override
	public Iterator<E> iterator() {
		//Also implements the iterator interface
		return new MyListIterator();
	}

	@Override
	public ListIterator<E> listIterator() {
		return new MyListIterator();
	}



	private class MyListIterator implements ListIterator<E> {
		
		int index = 0;
		boolean isPrevious = false;
		boolean nextOrPreviousCall = false;
		boolean addCallAfterNextOrPrevious = false;

		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public E next() {
			
			if (!hasNext()) {
				throw new IndexOutOfBoundsException();
			}
			
			isPrevious = false;
			nextOrPreviousCall = true;
			
			return data[index++];
		}

		@Override
		public boolean hasPrevious() { 
			return index > 0;
		}

		@Override
		public E previous() {
			
			if (!hasPrevious()) {
				throw new IndexOutOfBoundsException();
			}
			
			index--;
			
			isPrevious = true;
			nextOrPreviousCall = true;
			return data[index];
		}

		@Override
		public int nextIndex() {
			return index;
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}

		@Override
		public void remove() {
			
			if (!nextOrPreviousCall && addCallAfterNextOrPrevious) {
				data[index] = null;
				
				System.arraycopy(data, index + 1 , data, index, size - index); 
				
				size--;
			}
			
			
		}

		@Override
		public void set(E e) {
			
			int pos;
			
			if (isPrevious) {
				pos = index + 1;
			} else {
				pos = index - 1;
			}
			
			data[pos] = e;
			
		}

		@Override
		public void add(E e) {

			if (size >= data.length) {
				aumentarEspacio(1);
			}
			
			int pos = 0;
			
			if (isPrevious) {
				pos = index + 1;
			} else {
				pos = index - 1;
			}
			
			System.arraycopy(data, index, data, index + 1, size - index);
			
			data[index++] = e;
			
			size++;
			
			if (nextOrPreviousCall) {
				addCallAfterNextOrPrevious = true;
				nextOrPreviousCall = false;
			}
			
		}
		
	}
}











