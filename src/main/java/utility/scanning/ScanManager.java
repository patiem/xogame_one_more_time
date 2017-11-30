package utility.scanning;

public class ScanManager {

    private ScanManager(){}

    private static Scanning scanner = new TScanner();

    public static Scanning getScanner() {
        return scanner;
    }

    public static void setScanner(String fileName) throws IllegalArgumentException {
        scanner = FileScanner.createFileScanner(fileName);
    }


}
