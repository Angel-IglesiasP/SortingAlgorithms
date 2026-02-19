package shapes;

public abstract class Prism extends Shape
{
	//attribute
	private double side;
	
	public Prism(double height, double side)
	{
		super(height);
		this.side = side;
	}
	
	
	/**
	 * @return the side
	 */
	public double getSide()
	{
		return side;
	}


	@Override
	public double calcVolume()
	{
		return calcBaseArea() * getHeight();
	}
}
