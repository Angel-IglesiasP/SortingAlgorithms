package shapes;

public class Pyramid extends Shape {
	//attribute 
	private double side;

	/**
	 * Creates a square pyramid.
	 * @param height pyramid height
	 * @param side side length of the square base
	 */
	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}

	/**
	 * Returns the base side length.
	 * @return side length
	 */
	public double getSide() {
		return side;
	}
	
	@Override
	/**
	 * Computes base area (side^2).
	 * @return base area
	 */
	public double calcBaseArea() {
		return side * side;
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
