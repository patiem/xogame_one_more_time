package utility.printing;

import utility.language.Language;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class FilePrinter implements Printer {

    private PrintWriter writer;
    private ResourceBundle subtitles;

    static FilePrinter build() throws IOException {
        File result = new File("result.txt");
        result.createNewFile();
        return new FilePrinter(new PrintWriter(new FileWriter(result)));
    }

    FilePrinter(PrintWriter printer)  {
        writer = printer;
    }

    @Override
    public void setLanguage(ResourceBundle subtitles) {
        this.subtitles = subtitles;
    }

    @Override
    public void printMsg(String message) {
        writer.println(message);
    }

    @Override
    public void printMsg(Language langMsg, String... blanks) {
        if(blanks.length == 0) printMsg(subtitles.getString(langMsg.toString()));
        else printMsg(String.format(subtitles.getString(langMsg.toString()), blanks));
    }

    void close() {
        writer.close();
    }
}
