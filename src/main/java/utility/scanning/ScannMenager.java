package utility.scanning;

import java.io.FileNotFoundException;


public class ScannMenager {

    private static Scanning scanner = new TScanner();

    public static Scanning getScanner() {
        return scanner;
    }

    public static void setScanner(String fileName) {
        scanner = new FileScanner(fileName);
    }


}
