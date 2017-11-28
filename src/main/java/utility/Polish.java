package utility;

public enum Polish {

    EMPTY(""),

    MSG_NAME_ONE("Podaj imie pierwszego gracza"),
    MSG_NAME_TWO("Podaj imie drugiego gracza"),
    MSG_SIGN("Podaj X czy O"),
    MSG_PLAYER_COMPLETE("Graczu %s - grasz jako %s"),

    MSG_VERTICAL("Podaj szerokość większą lub równą 3 i mniejsza niz 100"),
    MSG_HORIZONTAL("Podaj wysokość większą lub równą 3 i mniejsza niz 100"),
    MSG_WIN_LENGTH("Podaj ile znakow do wygranej (minimum 3 ale nie wiecej niz %d"),
    MSG_BOARD_COMPLETE("Twoja tablica ma rozmiar %d x %d - aby wygrać potrzeba %d znaków"),

    MSG_RND_COUNT("---------Rozpoczyna się runda %d----------"),
    MSG_RND_PLAYER("Zaczyna gracz %s"),

    MSG_PLAYER("Graczu %s "),
    MSG_CELL_NUMBER("Podaj numer komórki, na której chcesz postawic swój znak\nLub dowolną literę aby wyjść z gry"),

    MSG_WIN("Graczu %s - wygrałeś tą rundę"),
    MSG_DRAW("Gra zakońcozna remisem"),
    MSG_SCORE("Gracz %s X : %d punktów ||| Gracz %s O : %d punktów"),

    MSG_EXIT_GAME("Gra zostaje zakończona"),

    ERR_NAME("Imie musi mieć gługośc między 3 a 20 znaków, spróbuj jeszcze raz"),
    ERR_SIGN("Twój znak nie był ani O ani X, więc przydzielamy Ci X"),
    ERR_BOARD_SIZE("To nie jest >= 3 w związku z tym zdecyduję za Ciebie, że będzie 3"),
    ERR_CELL_NUMBER("Spróbujmy jeszcze raz - tym razem traf w tablicę\n" +
                            "Podaj numer komórki, na której chcesz postawic swój znak\n" +
                            "Lub dowolną literę aby wyjść z gry"),
    ERR_CELL_OCCUPIED("Pole zajęte - spróbuj jeszcze raz"),

    WIN_X(  "\nXX THE WINNER IS  XX\n" +
            "XXXXXXXXXXXXXXXXXXXX\n" +
            "XXXXX  XXXXXX  XXXXX\n" +
            "XXXXXX  XXXX  XXXXXX\n" +
            "XXXXXXX  XX  XXXXXXX\n" +
            "XXXXXXXX    XXXXXXXX\n" +
            "XXXXXXX  XX  XXXXXXX\n" +
            "XXXXXX  XXXX  XXXXXX\n" +
            "XXXXX  XXXXXX  XXXXX\n" +
            "XXXXXXXXXXXXXXXXXXXX"),

    WIN_O(  "\nOO THE WINNER IS  OO\n" +
            "OOOOOOOOOOOOOOOOOOOO\n" +
            "OOOOOOO      OOOOOOO\n" +
            "OOOOO  OOOOOO  OOOOO\n" +
            "OOOO  OOOOOOOO  OOOO\n" +
            "OOOO  OOOOOOOO  OOOO\n" +
            "OOOO  OOOOOOOO  OOOO\n" +
            "OOOOO  OOOOOO  OOOOO\n" +
            "OOOOOOO      OOOOOOO\n" +
            "OOOOOOOOOOOOOOOOOOOO"),

    DRAW("\nREMIS");

    public String msg;

    Polish(String sign) {
        this.msg = sign;
    }

    @Override
    public String toString() {
        return msg;
    }

}
