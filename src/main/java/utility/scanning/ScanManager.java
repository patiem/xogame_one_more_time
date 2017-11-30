package utility.scanning;

public class ScanManager {

    private ScanManager(){}

    private static Scanning scanner = new TerminalScanner();

    public static Scanning getScanner() {
        return scanner;
    }

    public static void setScanner(String fileName) {
        scanner = FileScanner.createFileScanner(fileName);
    }
}