package utility.language;

import java.util.ResourceBundle;

public class LanguageLoader {

     public static ResourceBundle loadLanguage(String lg) {
         if (lg.equalsIgnoreCase("EN")) return ResourceBundle.getBundle("Language_en");
         else if (lg.equalsIgnoreCase("PL")) return ResourceBundle.getBundle("Language_pl");
         return ResourceBundle.getBundle("Language");
     }
}
