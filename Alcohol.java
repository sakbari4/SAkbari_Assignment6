package Assignment6;

public class Alcohol extends Beverage{
	private boolean weekend;
	public static final double WEEKEND_DRINKS = 0.6;
	
	public Alcohol(String name, Size size,  boolean weekend) {
		super(name, Type.ALCOHOL, size);
		this.weekend = weekend;
	}
	
	public String toString() {
		return super.toString() + ", Weekend Special: " + weekend;
	}
	
	public boolean equals(Object object) {
		if(!super.equals(object)) {
			return false;
		}
		Alcohol alcohol = (Alcohol) object;
		return weekend == alcohol.weekend;
	}
	
	public double calcPrice() {
		double price = addSizePrice();
		if(weekend) {
			price += WEEKEND_DRINKS;
		}
		return price;
	}

}
