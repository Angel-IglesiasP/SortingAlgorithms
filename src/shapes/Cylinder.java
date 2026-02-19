package shapes;

public class Cylinder extends Shape
{
	//attributes
	private double radius;


	//constructor
	/**
	 * @param height
	 */
	public Cylinder(double height, double radius)
	{
		super(height);
		this.radius = radius;
	}
	
	@Override
	public double calcBaseArea()
	{
		return Math.PI * radius * radius;
	}
	
	@Override
	public double calcVolume()
	{
		return calcBaseArea() * getHeight();
	}
	
	
}
