package shapes;

public class OctagonalPrism extends Prism {
	/**
	 * Creates a regular octagonal prism.
	 * @param height prism height
	 * @param side side length of the regular octagon
	 */
	public OctagonalPrism(double height, double side) {
		super(height, side);
	}
	
	@Override
	/**
	 * Computes base area (2 * (1 + sqrt(2)) * side^2).
	 * @return base area
	 */
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * getSide() * getSide();
	}
}
