package lesson11.task1;

import java.io.IOException;
import java.time.LocalTime;

/**
 * Created by default on 1/29/2017.
 */
public class Runner {
    private static final int K = 1000;
    private static final int N = 50;

    public static void main(String[] args) throws IOException, InterruptedException {
        parallel();
        sequential();
        parallel();
        sequential();

    }

    private static void parallel() throws InterruptedException {
        LocalTime lt1;
        LocalTime lt2;//parallel block
        Factorial.cleanDirectory();
        Thread[] threads = new Thread[N + 1];
        lt1 = LocalTime.now();
        for (int i = 0; i <= N; i++) {
            threads[i] = new Thread(new Factorial(K * i));
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        lt2 = LocalTime.now();
        System.out.println("parallel time == " + (lt2.toNanoOfDay() - lt1.toNanoOfDay()) / 1000_000 + " milliseconds");
    }

    private static void sequential() {
        LocalTime lt1;
        LocalTime lt2;//sequential block
        Factorial.cleanDirectory();
        lt1 = LocalTime.now();
        for (int i = 0; i < N; i++) {
            new Factorial(K * i).run();
        }
        lt2 = LocalTime.now();
        System.out.println("sequential time == " + (lt2.toNanoOfDay() - lt1.toNanoOfDay()) / 1000_000 + " milliseconds");
    }
}
