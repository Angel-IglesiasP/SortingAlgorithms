package appDomain;

import shapes.Shape;
import sortingAlgorithms.BubbleSort;
import sortingAlgorithms.CombSort;
import sortingAlgorithms.InsertionSort;
import sortingAlgorithms.MergeSort;
import sortingAlgorithms.QuickSort;
import sortingAlgorithms.SelectionSort;

/**
 * CLI entry point for sorting shapes loaded from a file and printing a summary report.
 * Accepts file, measurement type and sorting type:  -f <file>, -t <h|a|v>, -s <b|i|s|c|q|m>.
 */
public class AppDriver {

    /**
     * Parses CLI args and dispatches sorting and reporting.
     * @param args -f <filename>, -t h|a|v (height, area, volume), -s b|i|s|c|q|m (algorithm)
     */
    public static void main(String[] args) {
        // variables for the options in the args arguments
        String filename = null;
        Character t = null;     // 'h', 'a', or 'v'
        String sortName = null; // get teh sorting type, bubble, quick, etc

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if (arg.toLowerCase().startsWith("-f")) {
                if (arg.length() > 2) {
                    //no spaces
                    filename = arg.substring(2);
                } else {
                    //  in case of spaces
                    if (i + 1 >= args.length) exitWithError("Missing filename after -f");
                    filename = args[++i];
                }
                
            } else if (arg.toLowerCase().startsWith("-t")) {

                String value;
                if (arg.length() > 2) {
                    // no spaces
                    value = arg.substring(2).toLowerCase();
                } else {
                    // spaces
                    if (i + 1 >= args.length) exitWithError("Missing type after -t (h|a|v)");
                    value = args[++i].toLowerCase();
                }

                if (value.length() != 1) exitWithError("Invalid -t value: " + value + " (expected h, a, or v)");
                t = value.charAt(0);
                if (t != 'h' && t != 'a' && t != 'v')
                    exitWithError("Invalid -t value: " + t + " (expected h, a, or v)");
                
            } else if (arg.toLowerCase().startsWith("-s")) {

                if (arg.length() > 2) {
                    //no spaces
                    sortName = arg.substring(2).toLowerCase();
                } else {
                    // spaces
                    if (i + 1 >= args.length) exitWithError("Missing sort name after -s");
                    sortName = args[++i].toLowerCase();
                }
                
            } else {
                exitWithError("Unknown argument: " + arg);
            }
        }

        // in case the parametors are empty or wrong
        if (filename == null) exitWithError("Missing valid file, try: -f (shapes1.txt)");
        if (t == null) exitWithError("Missing valid messurament option, try one of these: -t h, a or v");
        if (sortName == null) exitWithError("Missing valid algorithm option, try one of these: -s b, q, m, i, c, s");

        // Load shapes 
        Shape[] original = FileHandler.loadShapes(filename);

        // clone the array to avoid mutation. each sort gets a disorganize array
        Shape[] working = original.clone();

        // starts a timer and measure how quick an algorithm run and print it in the console
        long start = System.nanoTime();

        if ("b".equals(sortName)) {
            BubbleSort.bubbleSort(working, t);
        } else if ("i".equals(sortName)) {
            InsertionSort.insertionSort(working, t);
        } else if ("s".equals(sortName)) {
            SelectionSort.selectionSort(working, t);
        } else if ("c".equals(sortName)) {
            CombSort.combSort(working, t);
        } else if ("q".equals(sortName)) {
            QuickSort.quickSort(working, t);
        } else if ("m".equals(sortName)) {
            MergeSort.mergeSort(working, t);
        } else {
            exitWithError("Unsupported sorting algorithm try: b, i, s, c, q, m ");
        }

        long end = System.nanoTime();
        long elapsedNs = end - start;
        double elapsedMs = elapsedNs / 1_000_000.0;

        // prints the output to the console woth the time the algorithm name the first shape, last shape and every 1000shape
        printReport(working, t, sortName, elapsedMs);
    }

    /**
     * Prints first element, every 1000th element, last element, and elapsed time.
     * @param arr sorted array to display
     * @param t comparison mode (h, a, v)
     * @param sortName algorithm key (b/i/s/c/q/m)
     * @param elapsedMs elapsed milliseconds
     */
    private static void printReport(Shape[] arr, char t, String sortName, double elapsedMs) {
        int n = arr.length;

        System.out.println("number of shapes: " + n);
        System.out.println();

        if (n == 0) {
            System.out.println("No shapes to display.");
            return;
        }

        System.out.println("First element is: " + arr[0]);
        System.out.println();

        System.out.println("------------------------------ Every 1000th element: ------------------------------");
        System.out.println();
        for (int i = 0; i < n; i += 1000) {
            System.out.println("Index " + i + ": " + arr[i]);
            System.out.println();
        }
        
        System.out.println("Last element is: " + arr[n - 1]);
        System.out.println();
        System.out.printf("Sort time: %.3f miliseconds%n", elapsedMs);

    }

    /**
     * Writes an error message.
     * @param message problem description
     */
    private static void exitWithError(String message) {
        System.err.println("Error: " + message);
        System.err.println("Usage: java app.AppDriver -f <filename> -t <h|a|v> -s <bubble|...>");
        System.exit(1);
    }
}
