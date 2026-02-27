package shapes;

public class Cylinder extends Shape {
	//attributes
	private double radius;

	/**
	 * Creates a cylinder.
	 * @param height cylinder height
	 * @param radius cylinder radius
	 */
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
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
	 * Computes volume (base area * height).
	 * @return volume
	 */
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}
}
