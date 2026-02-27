package shapes;

public class TriangularPrism extends Prism {
	/**
	 * Creates an equilateral triangular prism.
	 * @param height prism height
	 * @param side side length of the equilateral triangle
	 */
	public TriangularPrism(double height, double side) {
		super(height, side);
	}
	
	@Override
	/**
	 * Computes base area ((side^2 * sqrt(3)) / 4).
	 * @return base area
	 */
	public double calcBaseArea() {
		return (getSide() * getSide() * Math.sqrt(3)) / 4;
	}
}
