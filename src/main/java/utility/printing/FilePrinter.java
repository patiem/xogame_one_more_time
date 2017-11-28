package utility.printing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

public class FilePrinter implements Printer {

    private PrintWriter writer;

    public FilePrinter() throws IOException {
        File result = new File("result.txt");
        result.createNewFile();
        writer = new PrintWriter(new FileWriter(result));
    }


    @Override
    public void printMsg(String message) {
        writer.println(message);
    }

    @Override
    public void printMsgWithoutNewLine(String msg) {
        writer.print(msg);
    }

    void close() {
        writer.close();
    }
}
