package estdatos;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> extends AbstractList<E> {
	
	private E[] datos; 
	private int size;
	
	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("capacidad negativa: " + initialCapacity);
		}
		this.datos = (E[]) new Object[initialCapacity];
		this.size = 0;
	}
	
	public MyArrayList() {
		this(10);
	}
	
	public MyArrayList(Collection<E> c) {
		this.datos = (E[]) new Object[c.size()];
		this.size = 0;
		addAll(c);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E get(int index) {
		comprobarIndex(index);
		return datos[index];
	}

	@Override
	public E set(int index, E element) {
		comprobarIndex(index);
		E oldValue = datos[index];
		datos[index] = element;
		return oldValue;
	}
	
	@Override
	public boolean add(E e) {
		ensureCapacity(size + 1);
		datos[size++] = e;
		return true;
	}
	
	
	@Override
	public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("ondice: " + index + ", tamaño: " + size);
		}
		ensureCapacity(size + 1);
		System.arraycopy(datos, index, datos, index + 1, size - index);
		datos[index] = element;
		size++;
	}
	
	@Override
	public E remove(int index) {
		comprobarIndex(index);
		E oldValue = datos[index];
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(datos, index + 1, datos, index, numMoved);
		}
		datos[--size] = null;
		return oldValue;
	}

	public int capacity() {
		return datos.length;
	}

	private void ensureCapacity(int capacidadMinima) {
		if (capacidadMinima > capacity()) {
			int capacidadNueva = capacity() * 2;
			if (capacidadNueva < capacidadMinima) {
				capacidadNueva = capacidadMinima;
			}
			System.out.println("Aumento capacidad de " + capacity() + " a " + capacidadNueva);
			datos = Arrays.copyOf(datos, capacidadNueva);
		}
	}

	private void comprobarIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("indice: " + index + ", tamaño: " + size);
		}
	}
	
}
