package utility.printing;

import utility.language.Language;

import java.util.ResourceBundle;

class ErrorPrinter implements Printer {

    private ResourceBundle subtitles;

    @Override
    public void setLanguage(ResourceBundle subtitles) {
        this.subtitles = subtitles;
    }

    @Override
    public void printMsg(String message) {
        System.err.println(message);
    }

    @Override
    public void printMsg(Language langMsg, String... blanks) {
        if(blanks.length == 0) printMsg(subtitles.getString(langMsg.toString()));
        else printMsg(String.format(subtitles.getString(langMsg.toString()), blanks));
    }
}
