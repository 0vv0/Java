package lesson11.task1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalTime;

/**
 * Created by default on 1/29/2017.
 */
public class Factorial implements Runnable {
    public static final String PATH = "src\\lesson11\\task1\\files\\";
    private static final int K = 1000;
    private static final int N = 100;
    private final int base;
    protected BigInteger factorial;

    public Factorial(int k) {
        this.base = k;
    }

    //1. Написать метод вычисления факториала.
//2. Написать метод вывода значения факториала в файл.
//3. Написать метод, в котором N потоков под индексами i = 1..N параллельно вычисляют факториал числа (K * i)
// и записывают в файл с названием "factorial K * i" (например, для K = 1000, "factorial K", "factorial 2K", ....)
//    Дополнительно:
//            4. Произвести бенчмарк и сравнить скорость работы многопоточного и аналогичного однопоточного кода.
//    Протестировать программу для N = 100, K = 1000.
    public static void main(String[] args) throws IOException, InterruptedException {
        LocalTime lt1;
        LocalTime lt2;
//      clean directory/delete all files
        for (int i = 0; i <= N; i++) {
            new File(PATH + "factorial " + K * i).delete();
        }
//        get current time for benchmark
        lt1 = LocalTime.now();
//        starts N threads and run factorial calculation in them
        for (int i = 0; i <= N; i++) {
            new Thread(new Factorial(K * i)).start();
        }
//        wait for last file with factorial is written
        while (!new File(PATH + "factorial " + K * N).exists()) {
            Thread.sleep(1000);
        }
//        get current time for benchmark
        lt2 = LocalTime.now();
        System.out.println("parallel time == " + (lt2.toNanoOfDay() - lt1.toNanoOfDay()) / 1000_000 + " milliseconds");

//      clean directory/delete all files
        for (int i = 0; i <= N; i++) {
            new File(PATH + "factorial " + K * i).delete();
        }
//        get current time for benchmark
        lt1 = LocalTime.now();
//        calculate factorials and write them to files sequentially
        for (int i = 0; i < N; i++) {
            new Factorial(K * i).run();
        }
//        get current time for benchmark
        lt2 = LocalTime.now();
        System.out.println("sequential time == " + (lt2.toNanoOfDay() - lt1.toNanoOfDay()) / 1000_000 + " milliseconds");
    }

    public static BigInteger get(int i) {
        if (i < 2) {
            return BigInteger.ONE;
        }
        BigInteger m = BigInteger.ONE;
        for (int y = 1; y <= i; y++) {
            m = m.multiply(BigInteger.valueOf(y));
        }
        return m;
    }

    @Override
    public void run() {
        factorial = get(base);

        try {
            write(new File(PATH + "factorial " + base));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(File file) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(factorial.toString());
        }
    }
}
