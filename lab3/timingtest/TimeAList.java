package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();


    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE

        //Create the necessary ALists that will be used in printTimingTable
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int testAListLength = 1000;

        for (int mult_n = testAListLength; mult_n <= 128000; mult_n *= 2) {

            //Add the current length to Ns arraylist
            Ns.addLast(mult_n);
            AList<Integer> testAList = new AList<>();
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < mult_n; i++) {
                testAList.addLast(i);
            }
            //Add the time and length to times and opCounts arraylist (opCounts == Length)
            times.addLast(sw.elapsedTime());
            opCounts.addLast(mult_n);

        }

        printTimingTable(Ns, times, opCounts);
    }
}
