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
    public static void main(String[] args) throws IOException {
        LocalTime lt1;
        LocalTime lt2;
        lt1 = LocalTime.now();
        for (int i = 0; i < N; i++) {
            new Factorial(K * i).run();
        }
        lt2 = LocalTime.now();
        System.out.println("parallel time == " + (lt2.toNanoOfDay() - lt1.toNanoOfDay()) / 1000_000 + " milliseconds");

//        Factorial f;
        lt1 = LocalTime.now();
        for (int i = 0; i < N; i++) {
            Factorial f = new Factorial(K * i);
            f.factorial = Factorial.get(f.base);
            f.write(new File("src\\lesson11\\task1\\files\\" + "factorial " + f.base));
        }
        lt2 = LocalTime.now();
        System.out.println("sequential time == " + (lt2.toNanoOfDay() - lt1.toNanoOfDay()) / 1000_000 + " milliseconds");
    }

    public static BigInteger get(int i) {
        if (i < 2) {
            return new BigInteger(String.valueOf(1));
        }
        BigInteger m = BigInteger.ONE;
        for (int y = 1; y <= i; y++) {
            m = m.multiply(new BigInteger(String.valueOf(y)));
        }
        return m;
    }

    @Override
    public void run() {
        factorial = get(base);

        try {
            write(new File("src\\lesson11\\task1\\files\\" + "factorial " + base));
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
