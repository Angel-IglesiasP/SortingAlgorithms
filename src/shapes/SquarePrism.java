package shapes;

public class SquarePrism extends Prism {
	/**
	 * Creates a square prism.
	 * @param height prism height
	 * @param side side length of the square
	 */
	public SquarePrism(double height, double side) {
		super(height, side);
	}
	
	@Override
	/**
	 * Computes base area (side^2).
	 * @return base area
	 */
	public double calcBaseArea() {
		return getSide() * getSide();
	}
}
