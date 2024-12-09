package Assignment6;

public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	private double price;
	private static final double EXTRA_SHOT = 0.5;
	private static final double EXTRA_SYRUP = 0.5;
	
	public Coffee(String name, Size size, boolean shot, boolean syrup) {
		super(name, Type.COFFEE, size);
		shot = extraShot;
		syrup = extraSyrup;
	}
	
	public String toString() {
		return super.toString() + ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup;
	}
	
	public double calcPrice() {
		double price = addSizePrice();
		if (extraShot) {
			price += EXTRA_SHOT;
		}
		if (extraSyrup) {
			price += EXTRA_SYRUP;
		}
		return price;
	}
	
	public boolean equals (Object object) {
		if (!super.equals(object)) {
			return false;
		}
		Coffee coffee = (Coffee) object;
		return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
	}

	
}
