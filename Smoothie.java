package Assignment6;

public class Smoothie extends Beverage {
	private int numOfFruits;
	private boolean powder;
	private static final double PROTEIN = 1.5;
	private static final double FRUIT = 0.5;
	
	public Smoothie(String name, Size size, int fruits, boolean protein) {
		super(name, Type.SMOOTHIE, size);
		fruits = numOfFruits;
		protein = powder;
	}
	
	public String toString() {
		return super.toString() + ", Fruits: " + numOfFruits + ", Protein Powder: " + powder;
	}
	
	public boolean equals (Object object) {
		if (!super.equals(object)) {
			return false;
		}
		Smoothie smoothie = (Smoothie) object;
		return numOfFruits == smoothie.numOfFruits && powder == smoothie.powder;
	}
	
	public double calcPrice() {
		double price = addSizePrice();
		if (powder) {
			price += PROTEIN;
		}
		price += numOfFruits * FRUIT;
		return price;
	}
}
