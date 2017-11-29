package utility.printing;

import utility.language.Language;

import java.util.ResourceBundle;

class TerminalPrinter implements Printer {


    private ResourceBundle subtitles;

    void setSubtitles(ResourceBundle subtitles) {
        this.subtitles = subtitles;
    }


    @Override
    public void printMsg(String message) {
        System.out.println(message);
    }

    @Override
    public void printMsgWithoutNewLine(String message) {
        System.out.print(message);
    }

//    @Override
//    public void printMsg(Language... msg) {
//
//    }

    @Override
    public void setLanguage(ResourceBundle subtitles) {

    }

    @Override
    public void printMsg(Language msgPlayerComplete, String... blanks) {

    }

}
