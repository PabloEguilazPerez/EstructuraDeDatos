package app;

import java.util.Comparator;

import estdatos.MyArrayList;
import estdatos.SortedList;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("--------------------------------------");
		System.out.println("MyArrayList");
		System.out.println("--------------------------------------");
		
		MyArrayList<Integer> arr = new MyArrayList<>();
		System.out.println("Size: " + arr.size() + ", Capacity: " + arr.capacity());
		arr.add(2);
		System.out.println("Size: " + arr.size() + ", Capacity: " + arr.capacity());
		arr.add(3);
		System.out.println("Size: " + arr.size() + ", Capacity: " + arr.capacity());
		arr.add(1);
		System.out.println("Size: " + arr.size() + ", Capacity: " + arr.capacity());
		System.out.println("Valores: " + arr.toString());
		
		arr = new MyArrayList<>(2);
		System.out.println("Size: " + arr.size() + ", Capacity: " + arr.capacity());
		arr.add(2);
		System.out.println("Size: " + arr.size() + ", Capacity: " + arr.capacity());
		arr.add(3);
		System.out.println("Size: " + arr.size() + ", Capacity: " + arr.capacity());
		arr.add(1);
		System.out.println("Size: " + arr.size() + ", Capacity: " + arr.capacity());
		System.out.println("Valores: " + arr.toString());
		
		System.out.println("--------------------------------------");
		System.out.println("Sorted List");
		System.out.println("--------------------------------------");
		
		SortedList<Integer> sortArr = new SortedList<>();
		System.out.println("Size: " + sortArr.size() + ", Capacity: " + sortArr.capacity());
		sortArr.add(2);
		System.out.println("Size: " + sortArr.size() + ", Capacity: " + sortArr.capacity());
		sortArr.add(3);
		System.out.println("Size: " + sortArr.size() + ", Capacity: " + sortArr.capacity());
		sortArr.add(1);
		System.out.println("Size: " + sortArr.size() + ", Capacity: " + sortArr.capacity());
		System.out.println("Vsalores: " + sortArr.toString());
			
		System.out.println("--------------------------------------");
		System.out.println("Sorted List pasando comparador");
		System.out.println("--------------------------------------");
				
		Comparator<Integer> com = (e1, e2) -> {
			return e2 - e1;
		};
		
		sortArr = new SortedList<>(2, com);
		System.out.println("Size: " + sortArr.size() + ", Capacity: " + sortArr.capacity());
		sortArr.add(2);
		System.out.println("Size: " + sortArr.size() + ", Capacity: " + sortArr.capacity());
		sortArr.add(3);
		System.out.println("Size: " + sortArr.size() + ", Capacity: " + sortArr.capacity());
		sortArr.add(1);
		System.out.println("Size: " + sortArr.size() + ", Capacity: " + sortArr.capacity());
		System.out.println("Valores: " + sortArr.toString());
		
	}
	
}
