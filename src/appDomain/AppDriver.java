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

        // Required options
        if (filename == null) exitWithError("Missing required option: -f <filename>");
        if (t == null) exitWithError("Missing required option: -t <h|a|v>");
        if (sortName == null) exitWithError("Missing required option: -s <algorithm>");

        // 2) Load shapes (NOT part of benchmark)
        Shape[] original = FileHandler.loadShapes(filename);

        // 3) Clone for fairness (NOT part of benchmark)
        Shape[] working = original.clone();

        // 4) Sort (benchmark ONLY this section)
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

        // 5) Output required elements (NOT part of benchmark)
        printReport(working, t, sortName, elapsedNs);
    }

    private static void printReport(Shape[] arr, char t, String sortName, long elapsedNs)
    {
        int n = arr.length;

        System.out.println("File loaded shapes: " + n);
        System.out.println("Sort: " + sortName + " | Criterion (-t): " + t);
        System.out.println("Sort time (ns): " + elapsedNs);
        System.out.println();

        if (n == 0)
        {
            System.out.println("No shapes to display.");
            return;
        }

        System.out.println("First element (index 0):");
        System.out.println(arr[0]);
        System.out.println();

        System.out.println("Last element (index " + (n - 1) + "):");
        System.out.println(arr[n - 1]);
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