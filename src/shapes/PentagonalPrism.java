package shapes;

public class PentagonalPrism extends Prism {
	/**
	 * Creates a regular pentagonal prism.
	 * @param height prism height
	 * @param side side length of the regular pentagon
	 */
	public PentagonalPrism(double height, double side) {
		super(height, side);
	}
	
	@Override
	/**
	 * Computes base area (5 * side^2 / (4 * tan(54 degrees))).
	 * @return base area
	 */
	public double calcBaseArea() {
		return (5 * getSide() * getSide()) / (4 * Math.tan(Math.toRadians(54)));
	}
}
