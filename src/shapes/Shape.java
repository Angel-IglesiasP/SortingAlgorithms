package shapes;

public abstract class Shape implements Comparable<Shape>
{
//attribute
	private double height;
	
	//non-default constructor
	public Shape(double height)
	{
		this.height = height;
	}
	
	//getter (accessor)
	public double getHeight()
	{
		return height;
	}

	@Override
	public int compareTo(Shape other)
	{
		if(this.height > other.height)
		{
			return -1;
		}
		if(this.height < other.height)
		{
			return 1;
		}
		return 0;
	}

	public abstract double calcBaseArea();
	public abstract double calcVolume();
	
	@Override
	public String toString()
	{
	    return String.format(
	        "%s | h=%.3f | base=%.3f | vol=%.3f",
	        getClass().getSimpleName(),
	        getHeight(),
	        calcBaseArea(),
	        calcVolume()
	    );
	}
	
	
}
