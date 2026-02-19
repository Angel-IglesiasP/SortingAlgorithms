package shapes;

public class Cone extends Shape
{
//attribute
	private double radius;
	
	//non-default constructor
	public Cone(double height, double radius)
	{
		super(height);
		this.radius = radius;
	}
	
	//getter
	public double getRadius()
	{
		return radius;
	}
	
	@Override
	public double calcBaseArea()
	{
		return Math.PI * radius * radius;
	}
	
	@Override
	public double calcVolume()
	{
		return calcBaseArea() * getHeight() / 3;
	}
}
