import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class Threads {
    public static void applyOperator(double[] xs, DoubleUnaryOperator o,
                                     int start, int numElements) {
        for (int i = start; i < start + numElements; i++)
            xs[i] = o.applyAsDouble(xs[i]);
    }

    public static void applyOperatorParallel(double[] xs, DoubleUnaryOperator o, int numThreads) {
        int len = xs.length;
        int lenPerThread = len / numThreads;
        int over = len % numThreads;
        int start = 0;
        int delta = 1;
        List<Thread> lt = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            final int startnew = start;
            if (over > 0) {
                Thread t = new Thread(() -> applyOperator(xs, o, startnew, lenPerThread + 1));
                over--;
                start += lenPerThread + 1;
            } else {
                Thread t = new Thread(() -> applyOperator(xs, o, startnew, lenPerThread));
                start += lenPerThread;
            }
        }
        for (Thread t : lt) {
            t.start();
        }
        try {
            for (Thread t : lt) {
                t.join();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
