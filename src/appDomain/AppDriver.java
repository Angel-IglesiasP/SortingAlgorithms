package appDomain;

import shapes.Shape;
import sortingAlgorithms.BubbleSort;

public class AppDriver
{
    public static void main(String[] args)
    {
        // variables for the options in the args arguments
        String filename = null;
        Character t = null;     // 'h', 'a', or 'v'
        String sortName = null; // get teh sorting type, bubble, quick, etc

        for (int i = 0; i < args.length; i++)
        {
            String arg = args[i];

            if ("-f".equals(arg))
            {
                if (i + 1 >= args.length) exitWithError("Missing filename after -f");
                filename = args[++i];
            }
            else if ("-t".equals(arg))
            {
                if (i + 1 >= args.length) exitWithError("Missing type after -t (h|a|v)");
                String value = args[++i];
                if (value.length() != 1) exitWithError("Invalid -t value: " + value + " (expected h, a, or v)");
                t = value.charAt(0);
                if (t != 'h' && t != 'a' && t != 'v') exitWithError("Invalid -t value: " + t + " (expected h, a, or v)");
            }
            else if ("-s".equals(arg))
            {
                if (i + 1 >= args.length) exitWithError("Missing sort name after -s");
                sortName = args[++i].toLowerCase();
            }
            else
            {
            	exitWithError("Unknown argument: " + arg);
            }
        }

        // in case the parametors are empty
        if (filename == null) exitWithError("Missing required option: -f <filename>");
        if (t == null) exitWithError("Missing required option: -t <h|a|v>");
        if (sortName == null) exitWithError("Missing required option: -s <algorithm>");

        // Load shapes 
        Shape[] original = FileHandler.loadShapes(filename);

        // clone the array to avoid mutation. each sort gets a disorganize array
        Shape[] working = original.clone();

        // starts a timer and measure how quick an algorithm run and print it in the console
        long start = System.nanoTime();

        if ("b".equals(sortName))
        {
            BubbleSort.bubbleSort(working, t);
        }
        else
        {
        	exitWithError("Unsupported sort algorithm: " + sortName + " (currently implemented: bubble)");
        }

        long end = System.nanoTime();
        long elapsedNs = end - start;
        double elapsedMs = elapsedNs / 1_000_000.0;

        // prints the output to the console woth the time the algorithm name the first shape, last shape and every 1000shape
        printReport(working, t, sortName, elapsedMs);
    }

    private static void printReport(Shape[] arr, char t, String sortName, double elapsedMs)
    {
        int n = arr.length;

        System.out.println("number of shapes: " + n);
        System.out.printf("Sort time: %.3f miliseconds%n", elapsedMs);
        System.out.println();

        if (n == 0)
        {
            System.out.println("No shapes to display.");
            return;
        }

        System.out.println("First element is: " + arr[0]);
        System.out.println();

        System.out.println("Last element (index " + (n - 1) + "): " + arr[n - 1]);
        System.out.println();

        System.out.println("Every 1000th element:");
        for (int i = 0; i < n; i += 1000)
        {
            System.out.println("Index " + i + ": " + arr[i]);
        }
    }

    private static void exitWithError(String message)
    {
        System.err.println("Error: " + message);
        System.err.println("Usage: java app.AppDriver -f <filename> -t <h|a|v> -s <bubble|...>");
        System.exit(1);
    }
}