package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;

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

    public static void addHelper(AList<Integer> test,AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts,int count){
        //addLast for Ns AList
        Stopwatch stopwatch1 = new Stopwatch();
        for (int i = 1; i <= count; i++) {
            test.addLast(i);
        }
        times.addLast(stopwatch1.elapsedTime());
        Ns.addLast(count);
        opCounts.addLast(Ns.getLast());
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE

        AList<Integer> Ns= new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts= new AList<>();

        for (int i = 1000; i <= 128000; i*=2) {
            AList<Integer> test = new AList<>();
            addHelper(test,Ns,times,opCounts,i);
        }
        printTimingTable(Ns,times,opCounts);


    }
}
