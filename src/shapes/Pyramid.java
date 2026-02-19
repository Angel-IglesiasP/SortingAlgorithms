package shapes;

public class Pyramid extends Shape
{
	//attribute 
	private double side;

	//constructor
	/**
	 * @param height
	 */
	public Pyramid(double height, double side)
	{
		super(height);
		this.side = side;
	}


	//getter
	/**
	 * @return the side
	 */
	public double getSide()
	{
		return side;
	}
	
	@Override
	public double calcBaseArea()
	{
		return side * side;
	}
	
	@Override
	public double calcVolume()
	{
		return calcBaseArea() * getHeight() / 3;
	}
	
	
	
}


