package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shapes.Shape;
import shapes.Cylinder;
import shapes.Cone;
import shapes.Pyramid;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import shapes.PentagonalPrism;
import shapes.OctagonalPrism;

public final class FileHandler
{
    private FileHandler() { }

    public static Shape[] loadShapes(String filename)
    {
        try (Scanner scanner = new Scanner(new File(filename)))
        {
            // Read header
        	int count = Integer.parseInt(scanner.nextLine().trim());

            // allocate array
            Shape[] shapes = new Shape[count];

            // count the lines in the file matching it with the amount in the header
            for (int i = 0; i < count; i++)
            {
                String line = scanner.nextLine().trim();

                //check the tokens separation "type" "height" "dimension"
                String[] tokens = line.split("\\s+");
                if (tokens.length != 3)
                {
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
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException("File not found: " + filename, e);
        }
    }
    
    //case based on type of shape 
    private static Shape createShape(String type, double height, double dim)
    {
        switch (type)
        {
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