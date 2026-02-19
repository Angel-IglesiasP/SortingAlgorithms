package utilities;

import java.util.Comparator;
import shapes.Shape;

public final class ShapeComparison
{
    private ShapeComparison() { }

    public static Comparator<Shape> getComparator(char t)
    {
        switch (t)
        {
            case 'a':
            	return BaseAreaComparator.INSTANCE;

            case 'v': 
            	return VolumeComparator.INSTANCE;

            case 'h':
            	return null; // use Comparable

            default: 
            	throw new IllegalArgumentException("Invalid -t option: " + t);
        }
    }

    public static int compare(Shape s1, Shape s2, char t)
    {
        Comparator<Shape> comp = getComparator(t);
        return (comp == null) ? s1.compareTo(s2) : comp.compare(s1, s2);
    }
}
