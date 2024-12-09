package Assignment6;

public class Customer {
	private String name;
	private int age;
	
	public Customer (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Customer (Customer customer) {
		this.name =  customer.name;
		this.age = customer.age;
	}
	
	public String toString() {
		return "Customer Name: " + name + ", Age: " + age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
