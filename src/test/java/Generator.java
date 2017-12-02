import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
}
package com.company;

        import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws IOException {
        Integer i;
        Integer k;
        int randomNumber;

        for(i = 3; i < 20; i++) {
            for(k = 3; k < 20; k++) {


                for(Integer n = 3; n <= i && n <= k; n++) {
                    String fileName = "test" + i.toString() + k.toString() + + n + ".txt";
                    File file = new File(fileName);
                    file.createNewFile();
                    PrintWriter printWriter = new PrintWriter(new FileWriter(file));
                    printWriter.println("Pati");
                    printWriter.println("X");
                    printWriter.println("Lolo");
                    printWriter.println("X");
                    printWriter.println(i);
                    printWriter.println(k);

                    printWriter.println(n);
                    for(int m = 1; m < i * k; m++) {

                        printWriter.println(ThreadLocalRandom.current().nextInt(0, i * k));
                        printWriter.println(ThreadLocalRandom.current().nextInt(0, i * k));
                        printWriter.println(ThreadLocalRandom.current().nextInt(0, i * k));
                    }}

                printWriter.close();
            }
        }

    }
}
