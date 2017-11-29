package utility.printing;

import utility.language.Language;

import java.util.ResourceBundle;

public interface Printer {

    void printMsg(String message);

    void setLanguage(ResourceBundle subtitles);

    void printMsg(Language msgPlayerComplete, String... blanks);
}


//TODO: Add methods for printing