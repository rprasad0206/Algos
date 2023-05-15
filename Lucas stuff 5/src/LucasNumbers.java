import java.util.Scanner;

// Recursive function to compute L(n)
public class LucasNumbers {
    public static long getLucas(long n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 1;
        } else {
            return getLucas(n - 1) + getLucas(n - 2);
        }
    }

    // Main function to get input from the user and print sequence, also gets run time in millis for each Lucas number
    public static void main(String[] args) {
        long startTimeMain = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n for L(n): ");
        int n = scanner.nextInt();
        if (n < 0) {
            System.out.println("re-run and please enter a number that is 0 or greater");
        } else {
            long[] time = new long[n + 1];
            long startTime =  System.currentTimeMillis();
            System.out.print("The sequence L(0), L(1), ... , L(" + n + ") is: \n\n");
            for (int i = 0; i <= n; i++) {
                double ratio = (double) getLucas(i + 1) / getLucas(i);
                System.out.print("L(" + i + ") = " + getLucas(i) + " ");
                long endTime =  System.currentTimeMillis();
                long runTime = (endTime - startTime);
                time[i] = runTime;
                System.out.println("\nRuntime: L(" + i + ") = " + runTime + " milliseconds");
                if (n != i) {
                    System.out.println("\nRatio of L(" + (i + 1) + ")/L(" + i + "): " + ratio);
                }
            }
            long endTimeMain = System.currentTimeMillis();
            double runTimeMain = (endTimeMain - startTimeMain);
            System.out.println("\n\nTotal Runtime: " + (runTimeMain / 1000) + " seconds");

            System.out.println("\nRatio of run times:\n");
            for (int i = 0; i < n; i++) {
                double timeRatio = (double) time[i + 1] / time[i];
                System.out.println("Time(L(" + (i + 1) + "))/Time(L(" + i + "))= " + (timeRatio));
            }
            System.out.println("\n\n Order of Growth: O(n log n)" +
                    "\n because run time ratios gradually increase from 1 to around 1.6 so it is better than n^2 but worse than n" +
                    "\n(n iterations of log(n) " +
                    "\n\n Ratios of successive calculations: 1.6180339...");
        }
    }
}
