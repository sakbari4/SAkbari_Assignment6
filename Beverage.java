package Assignment6;

public abstract class Beverage {
	protected String name;
	protected Type type;
	protected Size size;
	protected static final double BASE_PRICE = 2.0;
	protected static final double SIZE_PRICE = 0.5;
	
	public Beverage (String name, Type type, Size size) {
		this.name = name;
		this.type = type;
		this.size  = size;
	}
	
	public double addSizePrice() {
		if (size == Size.MEDIUM) {
			return BASE_PRICE + SIZE_PRICE;
		} else if (size == Size.LARGE) {
			return  BASE_PRICE + 2 * SIZE_PRICE;
		}
		return BASE_PRICE;
	}
	
	public abstract double calcPrice();
	public String toString() {
		return name + " (" + size + ")";
	}
	
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Beverage bev = (Beverage) object;
		return name.equals(bev.name)&& type == bev.type && size == bev.size; 
	}
	public Type  getType() {
		return type;
	}
	
	public Size getSize() {
		return size;
	}


}
