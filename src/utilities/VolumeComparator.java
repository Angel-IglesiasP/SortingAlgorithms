package utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 * Comparator ordering shapes by volume descending; ties broken by height descending.
 * Singleton via INSTANCE.
 */
public final class VolumeComparator implements Comparator<Shape> {
    public static final VolumeComparator INSTANCE = new VolumeComparator();

    private VolumeComparator() { }

    @Override
    /**
     * Compares by volume, then by height if equal.
     * @return negative if s1 should come before s2 in descending order
     */
    public int compare(Shape s1, Shape s2) {
        // orders from largest to smallest
        int comp = Double.compare(s2.calcVolume(), s1.calcVolume());
        if (comp != 0) return comp;
        // if 2 areas are the same, the orders gets decided by the height
        return Double.compare(s2.getHeight(), s1.getHeight());
    }
}
