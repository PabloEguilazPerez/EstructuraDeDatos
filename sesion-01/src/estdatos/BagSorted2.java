package estdatos;

import java.util.Comparator;

public class BagSorted2<E> extends BagMod<E> {
	
	private Comparator<E> comparator;

	public BagSorted2(int capacity) {
		super(capacity);
		this.comparator = null;
	}
	
	public BagSorted2(int capacity, Comparator<E> comparator) {
		super(capacity);
		this.comparator = comparator;
	}

	@Override
	public boolean add(E elemento) {
		
	    if (size >= datos.length) {
	        return false;
	    }
	    
	    int posicion = 0;

	    for (int i = 0; i < this.size(); i++) {
	    	

	    	if (compare(datos[i], elemento) < 0) {
	    		posicion = i;
	    		break;
	    	} else  {
	    		posicion = this.size();
	    	}
	    	
	    }
	    
	    System.arraycopy(datos, posicion, datos, posicion + 1, (datos.length - (posicion + 1)));
	    
	    datos[posicion] = elemento;
	 
	    size++;
	    return true;
	}
	
	
	private int compare(E e1, E e2) {        
		if (comparator != null) {            
			return comparator.compare(e1, e2);        
		} else if (e1 instanceof Comparable) {            
			return ((Comparable<E>) e1).compareTo(e2);        
		} else {            
			throw new IllegalArgumentException("Los elementos no son comparables y no se ha proporcionado un Comparator.");        
		}    
	}

}