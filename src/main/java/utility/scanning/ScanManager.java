package utility.scanning;


public class ScanManager {

    private ScanManager(){}

    private static Scanning scanner = new TScanner();

    public static Scanning getScanner() {
        return scanner;
    }

    public static void setScanner(String fileName) {
        scanner = new FileScanner(fileName);
    }


}
