import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class Threads {


    public static void main(String... args)  {
        Thread threadA = new Thread(() -> compute ());
        Thread threadB = new Thread(() -> compute ());
        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



    private static int compute(){
        return 1 ;
    }
}
