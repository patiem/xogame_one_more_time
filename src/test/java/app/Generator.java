package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {


    public static List<String> generate() throws IOException {
        Integer hori;
        Integer vert;
        Integer win;
        String testName = "src/test/scenarios/test_";
        String resultName = "src/test/results/result_";
        List<String> prefixes = new ArrayList<>();

        for(hori = 3; hori < 20; hori++) {
            for(vert = 3; vert < 20; vert++) {
                for(win = 3; win <= hori && win <= vert; win++) {
                    String prefixName = hori.toString() +"_"+ vert.toString() +"_"+ win.toString() + ".txt";
                    prefixes.add(prefixName);
                    File fileTest = new File(testName+prefixName);
                    File resultTest = new File(resultName+prefixName);
                    fileTest.createNewFile();
                    resultTest.createNewFile();
                    PrintWriter printWriter = new PrintWriter(new FileWriter(fileTest));
                    printWriter.println("Pati");
                    printWriter.println("X");
                    printWriter.println("Lolo");
                    printWriter.println("X");
                    printWriter.println(hori);
                    printWriter.println(vert);
                    printWriter.println(win);
                    for(int m = 1; m < hori * vert * 3; m++) {

                        printWriter.println(ThreadLocalRandom.current().nextInt(0, hori * vert));
                        printWriter.println(ThreadLocalRandom.current().nextInt(0, hori * vert));
                        printWriter.println(ThreadLocalRandom.current().nextInt(0, hori * vert));
                    }
                    printWriter.println("e");
                    printWriter.close();

                }

            }
        }
        return prefixes;
    }
}
