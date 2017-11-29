package utility.printing;

import utility.language.Language;

import java.util.ResourceBundle;

class ErrorPrinter implements Printer {

    private ResourceBundle subtitles;

    @Override
    public void printMsg(String message) {
        System.err.println(message);
    }

    @Override
    public void printMsgWithoutNewLine(String msg) {
        {
            System.err.print(msg);
        }
    }

//    @Override
//    public void printMsg(Language... msg) {
//
//    }

    @Override
    public void setLanguage(ResourceBundle subtitles) {
        this.subtitles = subtitles;

    }

    @Override
    public void printMsg(Language msgPlayerComplete, String... blanks) {

    }
}
