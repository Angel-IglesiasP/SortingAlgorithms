package shapes;

public class Cone extends Shape {
	//attribute
	private double radius;
	
	/**
	 * Creates a cone.
	 * @param height cone height
	 * @param radius cone radius
	 */
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	/**
	 * Returns the cone radius.
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}
	
	@Override
	/**
	 * Computes base area (pi * r^2).
	 * @return base area
	 */
	public double calcBaseArea() {
		return Math.PI * radius * radius;
	}
	
	@Override
	/**
	 * Computes volume (base area * height / 3).
	 * @return volume
	 */
	public double calcVolume() {
		return calcBaseArea() * getHeight() / 3;
	}
}
