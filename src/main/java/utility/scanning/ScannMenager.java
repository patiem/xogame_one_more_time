package utility.scanning;

public class ScannMenager {

    private static Scanning scanner = new TScanner();

    public static Scanning getScanner() {
        return scanner;
    }
}
