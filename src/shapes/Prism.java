package shapes;

public abstract class Prism extends Shape {
	//attribute
	private double side;
	
	/**
	 * Creates a prism.
	 * @param height prism height
	 * @param side side length of the regular base
	 */
	public Prism(double height, double side) {
		super(height);
		this.side = side;
	}
	
	/**
	 * Returns the polygon side length.
	 * @return side length
	 */
	public double getSide() {
		return side;
	}

	@Override
	/**
	 * Computes volume as base area multiplied by height.
	 * @return volume
	 */
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}
}
