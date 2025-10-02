package estdatos;

import java.util.Collection;

public class BagSorted<E> extends BagMod<E> {

	public BagSorted(int capacity) {
		super(capacity);
	}
	
	@Override
	public boolean add(E elemento) {
		
	    if (size >= datos.length) {
	        return false;
	    }
	    
	    int posicion = 0;

	    for (int i = 0; i < this.size(); i++) {
	    	
	    	int comp = cmp((int) datos[i], (int) elemento);
	    	
	    	System.out.println("E1: " + (int) datos[i] + " E2: " + (int) elemento + " Comp: " + comp + " I: " + i);
	    	
	    	if (cmp((int) datos[i], (int) elemento) < 0) {
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
	
	
	private int cmp(int e1, int e2) {
		
		return e2 - e1;
		
	}

}