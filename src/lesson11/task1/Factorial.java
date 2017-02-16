package lesson11.task1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by default on 1/29/2017.
 */
public class Factorial implements Runnable {
    public static final String PATH = "src\\lesson11\\task1\\files";
    private final int base;
    private final String fileName;

    public Factorial(int k) {
        this.base = k;
        this.fileName = PATH + "\\factorial " + base;
    }

    public static void cleanDirectory() {
        File[] files = new File(PATH).listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }

    }

    public BigInteger get(int i) {
        if (i < 2) {
            return BigInteger.ONE;
        }
        BigInteger m = BigInteger.ONE;
        for (int y = 2; y <= i; y++) {
            m = m.multiply(BigInteger.valueOf(y));
        }
        return m;
    }

    @Override
    public void run() {
        try {
            write(get(base));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(BigInteger factorial) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(factorial.toString());
        }
    }
}
