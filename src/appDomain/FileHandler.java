package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Cone;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;

/**
 * Loads Shape definitions from a text file and constructs the corresponding objects.
 * The expected format is: first line = count, then one shape per line as: <Type> <height> <dimension>.
 */
public final class FileHandler {
    private FileHandler() { }

    /**
     * Reads shapes from the given file.
     * @param filename path to the input file
     * @return array of shapes in file order
     * @throws RuntimeException if the file cannot be opened
     * @throws IllegalArgumentException if a line has invalid format or type
     */
    public static Shape[] loadShapes(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            // Read header
            int count = Integer.parseInt(scanner.nextLine().trim());

            // allocate array
            Shape[] shapes = new Shape[count];

            // count the lines in the file matching it with the amount in the header
            for (int i = 0; i < count; i++) {
                String line = scanner.nextLine().trim();

                //check the tokens separation "type" "height" "dimension"
                String[] tokens = line.split("\\s+");
                if (tokens.length != 3) {
                    throw new IllegalArgumentException(
                        "Invalid format. Expected: <Type> <height> <dimension>. Line: " + line
                    );
                }

                String type = tokens[0];
                double height = Double.parseDouble(tokens[1]);
                double dim = Double.parseDouble(tokens[2]);
                shapes[i] = createShape(type, height, dim);
            }
            return shapes;       
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filename, e);
        }
    }
    
    /**
     * Factory for supported types: Cylinder, Cone, Pyramid, SquarePrism, TriangularPrism, PentagonalPrism, OctagonalPrism.
     * @param type shape type name
     * @param height height of the shape
     * @param dim radius or side length depending on type
     * @return constructed Shape
     * @throws IllegalArgumentException for unknown types
     */
    private static Shape createShape(String type, double height, double dim) {
        switch (type) {
            case "Cylinder":
                return new Cylinder(height, dim);
            case "Cone":
                return new Cone(height, dim);
            case "Pyramid":
                return new Pyramid(height, dim);
            case "SquarePrism":
                return new SquarePrism(height, dim);
            case "TriangularPrism":
                return new TriangularPrism(height, dim);
            case "PentagonalPrism":
                return new PentagonalPrism(height, dim);
            case "OctagonalPrism":
                return new OctagonalPrism(height, dim);
            default:
                throw new IllegalArgumentException(
                    "Unknown shape type '" + type);
        }
    }
}
