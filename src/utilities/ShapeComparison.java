package utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 * Helper for selecting comparison strategies and delegating comparisons based on a mode flag.
 */
public final class ShapeComparison {
    private ShapeComparison() { }

    /**
     * Returns a comparator for 'a' (area) or 'v' (volume); for 'h' returns null to indicate natural ordering.
     * @param t mode flag ('h','a','v')
     * @return comparator or null for natural ordering
     * @throws IllegalArgumentException for invalid flags
     */
    public static Comparator<Shape> getComparator(char t) {
        switch (t) {
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

    /**
     * Compares two shapes using the selected strategy.
     * @param s1 first shape
     * @param s2 second shape
     * @param t mode flag ('h','a','v')
     * @return negative, zero, or positive per Comparator contract
     */
    public static int compare(Shape s1, Shape s2, char t) {
        Comparator<Shape> comp = getComparator(t);
        return (comp == null) ? s1.compareTo(s2) : comp.compare(s1, s2);
    }
}
