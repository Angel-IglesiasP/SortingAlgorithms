package shapes;

public abstract class Shape implements Comparable<Shape> {
	//attribute
	private double height;
	
	/**
	 * Creates a shape with the given height.
	 * @param height height of the shape
	 */
	public Shape(double height) {
		this.height = height;
	}
	
	/**
	 * Returns the height of the shape.
	 * @return height
	 */
	public double getHeight() {
		return height;
	}

	@Override
	/**
	 * Compares by height in descending order.
	 * @param other other shape
	 * @return negative if this is taller, positive if shorter, zero if equal
	 */
	public int compareTo(Shape other) {
		if(this.height > other.height) {
			return -1;
		}
		if(this.height < other.height) {
			return 1;
		}
		return 0;
	}

	/**
	 * Computes the base area.
	 * @return base area
	 */
	public abstract double calcBaseArea();

	/**
	 * Computes the volume.
	 * @return volume
	 */
	public abstract double calcVolume();
	
	@Override
	/**
	 * Returns a representation including type, height, base area, and volume.
	 * @return string summary
	 */
	public String toString() {
	    return String.format(
	        "%s | height=%.2f | base_area=%.2f | volume=%.2f",
	        getClass().getSimpleName(),
	        getHeight(),
	        calcBaseArea(),
	        calcVolume()
	    );
	}
}
