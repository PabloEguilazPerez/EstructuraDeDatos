package estdatos;

public class Person implements Comparable<Person> {
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}

	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.getName());
	}

}