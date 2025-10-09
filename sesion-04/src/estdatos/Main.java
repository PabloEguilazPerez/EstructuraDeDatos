package estdatos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Main {

	public static void main(String[] args) {
		
		IList<Character> l1 = new SList<Character>();
		System.out.println(l1.size());

		l1.add('a');
		l1.add('b');
		l1.add('c');
		l1.add('d');
		l1.add('e');
		System.out.println(l1.size());

		SList<Character> l2 = new SList<Character>();

		l2.add('a');
		l2.add('b');
		l2.add('c');
		l2.add('d');
		l2.add('e');
		
		System.out.println(l2.size());
		
		System.out.println(l1.equals(l2));
		l1.remove('a');
		System.out.println(l1.equals(l2));
		

	}

}
