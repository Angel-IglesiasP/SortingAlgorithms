package shapes;

public class OctagonalPrism extends Prism
{
	//constuctor
	/**
	 * @param height
	 * @param side
	 */
	public OctagonalPrism(double height, double side)
	{
		super(height, side);
	}
	
	@Override
	public double calcBaseArea()
	{
		return 2 * (1 + Math.sqrt(2)) * getSide() * getSide();
	}
}
