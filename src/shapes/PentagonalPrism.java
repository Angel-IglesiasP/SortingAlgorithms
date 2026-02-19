package shapes;

public class PentagonalPrism extends Prism
{
	//constructor
	/**
	 * @param height
	 * @param side
	 */
	public PentagonalPrism(double height, double side)
	{
		super(height, side);
	}
	
	@Override
	public double calcBaseArea()
	{
		return (5 * getSide() * getSide()) / (4 * Math.tan(Math.toRadians(54)));
	}
}
